package br.com.meli.dhprojetointegrador.dto.request;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import br.com.meli.dhprojetointegrador.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
public class BatchStockPostRequest {

    @NotBlank(message = "O campo nome não pode estar em branco")
    @NotNull(message = "O campo nome não pode ser nulo")
    private Long batchNumber;

    @NotBlank(message = "O campo nome não pode estar em branco")
    @NotNull(message = "O campo nome não pode ser nulo")
    private Long productId;

    @NotBlank(message = "O campo nome não pode estar em branco")
    @NotNull(message = "O campo nome não pode ser nulo")
    private Float currentTemperature;

    @NotBlank(message = "O campo nome não pode estar em branco")
    @NotNull(message = "O campo nome não pode ser nulo")
    private Float minimumTemperature;

    @NotBlank(message = "O campo nome não pode estar em branco")
    @NotNull(message = "O campo nome não pode ser nulo")
    private Integer initialQuantity;

    @NotBlank(message = "O campo nome não pode estar em branco")
    @NotNull(message = "O campo nome não pode ser nulo")
    private Integer currentQuantity;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @NotBlank(message = "O campo nome não pode estar em branco")
    @NotNull(message = "O campo nome não pode ser nulo")
    private LocalDate dueDate;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @NotBlank(message = "O campo nome não pode estar em branco")
    @NotNull(message = "O campo nome não pode ser nulo")
    private LocalDate manufacturingDate;

    @NotBlank(message = "O campo nome não pode estar em branco")
    @NotNull(message = "O campo nome não pode ser nulo")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime manufacturingTime;

    @NotBlank(message = "O campo nome não pode estar em branco")
    @NotNull(message = "O campo nome não pode ser nulo")
    private Product product;

}