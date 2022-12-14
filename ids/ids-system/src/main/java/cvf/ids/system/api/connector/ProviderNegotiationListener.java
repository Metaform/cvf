package cvf.ids.system.api.connector;

import cvf.ids.system.api.statemachine.ContractNegotiation;

import java.util.Map;

/**
 * Implementations can be registered to receive contract negotiation events for a producer.
 */
@SuppressWarnings("unused")
public interface ProviderNegotiationListener extends NegotiationListener {

    /**
     * Invoked after a contract request has been received.
     */
    default void contractRequested(Map<String, Object> contractRequest, ContractNegotiation negotiation) {
    }

    /**
     * Invoked after a consumer agreement has been received.
     */
    default void consumerAgreed(ContractNegotiation negotiation) {
    }

    /**
     * Invoked after a consumer agreement has been received.
     */
    default void consumerVerified(Map<String, Object> verification, ContractNegotiation negotiation) {
    }

}
