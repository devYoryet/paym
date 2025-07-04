package com.zosh.modal;

import com.zosh.domain.PaymentMethod;
import com.zosh.domain.PaymentOrderStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "payment_orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_orders_seq_gen")
    @SequenceGenerator(name = "payment_orders_seq_gen", sequenceName = "payment_orders_seq", allocationSize = 1)
    private Long id;

    @Column(name = "amount")
    private Long amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 50)
    private PaymentOrderStatus status = PaymentOrderStatus.PENDING;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_method", length = 50)
    private PaymentMethod paymentMethod;

    @Column(name = "payment_link_id")
    private String paymentLinkId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "booking_id")
    private Long bookingId;

    @Column(name = "salon_id", nullable = false)
    private Long salonId;
}