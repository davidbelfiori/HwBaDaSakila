package org.bada.hw2.eccezioni;

public class NessunCustomerTrovato extends RuntimeException {
    public NessunCustomerTrovato(String message) {
        super(message);
    }
}
