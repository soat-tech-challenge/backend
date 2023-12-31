package br.com.grupo63.techchallenge.controller;

import br.com.grupo63.techchallenge.adapter.ProductAdapter;
import br.com.grupo63.techchallenge.controller.dto.ProductControllerDTO;
import br.com.grupo63.techchallenge.entity.product.Product;
import br.com.grupo63.techchallenge.exception.NotFoundException;
import br.com.grupo63.techchallenge.exception.ValidationException;
import br.com.grupo63.techchallenge.gateway.product.IProductGateway;
import br.com.grupo63.techchallenge.presenter.ProductPresenter;
import br.com.grupo63.techchallenge.usecase.product.ProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductController {

    private final ProductUseCase useCase;
    private final IProductGateway gateway;

    public ProductControllerDTO create(ProductControllerDTO productControllerDTO) throws ValidationException {
        Product product = new Product();
        ProductAdapter.fillEntity(productControllerDTO, product);
        product = useCase.create(product, gateway);
        return ProductPresenter.toDto(product);
    }

    public ProductControllerDTO read(Long id) throws NotFoundException {
        return ProductPresenter.toDto(useCase.read(id, gateway));
    }

    public List<ProductControllerDTO> list() {
        return useCase.list(gateway).stream().map(ProductPresenter::toDto).toList();
    }

    public ProductControllerDTO update(ProductControllerDTO productControllerDTO, Long id) throws ValidationException, NotFoundException {
        Product entity = useCase.read(id, gateway);
        ProductAdapter.fillEntity(productControllerDTO, entity);
        entity = useCase.update(entity, gateway);
        return ProductPresenter.toDto(entity);
    }

    public void delete(Long id) throws NotFoundException {
        // TODO: Perguntar se devemos usar o read aqui fora (controller) ou dentro do usecase
        // e se passamos o usecase ou gateway nesse caso
        Product entity = useCase.read(id, gateway);
        useCase.delete(entity, gateway);
    }

    public List<ProductControllerDTO> listByCategoryName(String categoryName) {
        List<Product> entities = useCase.listByCategoryName(categoryName, gateway);
        return entities.stream().map(ProductPresenter::toDto).toList();
    }

}
