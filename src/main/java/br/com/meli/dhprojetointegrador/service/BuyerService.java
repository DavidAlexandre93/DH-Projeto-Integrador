package br.com.meli.dhprojetointegrador.service;

import br.com.meli.dhprojetointegrador.entity.Buyer;
import br.com.meli.dhprojetointegrador.entity.PurchaseOrder;
import br.com.meli.dhprojetointegrador.enums.BuyerStatusEnum;
import br.com.meli.dhprojetointegrador.enums.StatusEnum;
import br.com.meli.dhprojetointegrador.exception.BuyerNotFoundException;
import br.com.meli.dhprojetointegrador.repository.BuyerRepository;
import br.com.meli.dhprojetointegrador.repository.PurchaseOrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class BuyerService {


    @Autowired
    BuyerRepository buyerRepository;

    @Autowired
    PurchaseOrderRepository purchaseOrderRepository;

    /**
     * @Author: David
     * @Description: Listar todas as purchaseOrder referentes ao Buyer
     * @return
     */
    public List<PurchaseOrder> listAllPurchases(Long id) {
        List<PurchaseOrder> purchaseOrders = purchaseOrderRepository.findByBuyerIdAndStatus(id, StatusEnum.FINALIZADO);
        return purchaseOrders;
    }



    /**
     * @Author: David
     * @Description: Listar todas as purchaseOrder referentes ao Buyer com um mesmo Status
     * @return
     */
    public List<PurchaseOrder> listAllPurchasesWithStatus(Long id, StatusEnum status) {
        List<PurchaseOrder> purchaseOrdersStatus = purchaseOrderRepository.findByBuyerIdAndStatus(id, status);
        return purchaseOrdersStatus;
    }

    /**
     * @Author: David
     * @Methodo:
     * @Description: Alterar os dados do buyer, pelo email/nome
     * @return
     */
    public Buyer updateDataBuyer(Long id, String name, String email) {

        try {

            Buyer buyerId = buyerRepository.findById(id).get();

            if(buyerId.getStatus().equals(BuyerStatusEnum.INATIVO)) {

                throw new BuyerNotFoundException("Comprador Inativo!");

            }else{
                buyerId.setName(name);
                buyerId.setEmail(email);
            }
            return buyerRepository.save(buyerId);
        }catch (NoSuchElementException e){

            throw new BuyerNotFoundException("Comprador inexistente!");
        }

    }


    /**
     * @Author: David
     * @Description: Desativar a conta a partir de email e password, setando Ativo e Inativo
     * @return
     */
    public Buyer deactivateBuyer(Long id) {

        try{
            Buyer buyerId = buyerRepository.findById(id).get();
            if(buyerId.getStatus().equals(BuyerStatusEnum.INATIVO)) {

                throw new BuyerNotFoundException("Comprador já inativo!");

            }else {

                buyerId.setStatus(BuyerStatusEnum.INATIVO);
                return buyerRepository.save(buyerId);
            }
        }catch (NoSuchElementException e){

            throw new BuyerNotFoundException("Comprador nao existe!");

        }

    }
}
