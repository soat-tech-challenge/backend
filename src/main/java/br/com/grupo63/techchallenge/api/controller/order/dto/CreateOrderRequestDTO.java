package br.com.grupo63.techchallenge.api.controller.order.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderRequestDTO {

    @Setter
    @Getter
    @AllArgsConstructor
    public static class Item {
        private Long id;
        private Long quantity;
    }

    private List<Item> items;

}
