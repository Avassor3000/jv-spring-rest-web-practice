package mate.academy.spring.mapper.impl.response;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.dto.response.OrderResponseDto;
import org.springframework.stereotype.Component;

@Component
public class OrderResponseMapper implements DtoResponseMapper<OrderResponseDto, Order> {
    @Override
    public OrderResponseDto toDto(Order order) {
        OrderResponseDto responseDto = new OrderResponseDto();
        responseDto.setId(order.getId());
        responseDto.setOrderDate(order.getOrderDate());
        responseDto.setUserId(order.getUser().getId());
        List<Long> collect = order
                .getTickets()
                .stream()
                .map(t -> t.getId())
                .collect(Collectors.toList());
        responseDto.setTicketId(collect);
        return responseDto;
    }
}
