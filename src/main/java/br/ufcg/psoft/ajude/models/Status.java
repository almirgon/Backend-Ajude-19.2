package br.ufcg.psoft.ajude.models;

public enum Status {

    ATIVA("Ativa"),
    ENCERRADA("Encerrada"),
    VENCIDA("Vencida"),
    CONCLUIDA("Concluída");

    private String description;

    Status(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
