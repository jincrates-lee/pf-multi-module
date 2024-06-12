package me.jincrates.apiclient.order.service.request;

public record OrderCancelRequest(
    Long orderId,
    Long userId
) {

}
