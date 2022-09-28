package hello.advanced.app.v0;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV0 {

    private final OrderRepositoryV0 orderRepository;

    //생성자
    /* ctrl+insert constructor
    public OrderService(OrderRepositoryV0 orderRepository) {
        this.orderRepository = orderRepository;
    }
    */

    public void orderItem(String itemId){
        orderRepository.save(itemId);
    }
}
