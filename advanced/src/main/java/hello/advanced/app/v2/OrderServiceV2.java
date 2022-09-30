package hello.advanced.app.v2;

import hello.advanced.trace.TraceId;
import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.hellotrace.HelloTraceV1;
import hello.advanced.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV2 {

    private final OrderRepositoryV2 orderRepository;
    private final HelloTraceV2 trace;

    //생성자
    /* ctrl+insert constructor
    public OrderService(OrderRepositoryV0 orderRepository) {
        this.orderRepository = orderRepository;
    }
    */

    public void orderItem(TraceId traceId, String itemId){
        TraceStatus status = null;
        try{
            status = trace.beginSync(traceId,"OrderServiceV1.orderItem()");
            orderRepository.save(status.getTraceId(), itemId);
            trace.end(status);
        }catch(Exception e){
            trace.exception(status, e);
            throw e;    //예외를 꼭 다시 던져줘야함
        }
    }
}
