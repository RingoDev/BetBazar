package com.ringodev.server.data.bet.database;



import com.ringodev.server.data.bet.Bet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;


@Component
public class BetModelListener extends AbstractMongoEventListener<Bet> {

    private final SequenceGeneratorService sequenceGenerator;

    @Autowired
    public BetModelListener(SequenceGeneratorService sequenceGenerator) {
        this.sequenceGenerator = sequenceGenerator;
    }

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Bet> event) {
        if (event.getSource().getId() < 1) {
            event.getSource().setId(sequenceGenerator.generateSequence(Bet.SEQUENCE_NAME));
        }
    }


}
