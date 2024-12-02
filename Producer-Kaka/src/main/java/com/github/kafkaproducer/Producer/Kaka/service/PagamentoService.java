package com.github.kafkaproducer.Producer.Kaka.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.kafkaproducer.Producer.Kaka.dto.PagamentoDTO;
import com.github.kafkaproducer.Producer.Kaka.producer.PagamentoRequestProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRequestProducer pagamentoRequestProducer;

    public String integrarPagamento(PagamentoDTO pagamentoDTO) {
        try {
            return pagamentoRequestProducer.sendMessage(pagamentoDTO);
        } catch (JsonProcessingException e) {
            return "Houve um erro ao enviar os dados de pagamento: " + e.getMessage();
        }
    }
}
