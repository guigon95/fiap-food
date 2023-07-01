package br.com.project.fiapfood.application.core.service;

import br.com.project.fiapfood.application.core.domain.Client;
import br.com.project.fiapfood.application.core.domain.port.in.SaveClientServicePort;
import br.com.project.fiapfood.application.core.domain.port.out.SaveClientPort;
import org.springframework.stereotype.Component;

@Component
public class SaveClientService implements SaveClientServicePort {

    private final SaveClientPort saveClientPort;

    public SaveClientService(SaveClientPort saveClientPort) {
        this.saveClientPort = saveClientPort;
    }

    @Override
    public Client saveClient(Client client) {
        return this.saveClientPort.save(client);
    }
}
