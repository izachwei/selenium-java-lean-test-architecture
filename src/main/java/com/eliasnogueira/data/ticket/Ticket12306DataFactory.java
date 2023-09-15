package com.eliasnogueira.data.ticket;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.eliasnogueira.model.TicketInfo;
import com.eliasnogueira.util.TrainUtil;
import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.extern.slf4j.Slf4j;
import org.aeonbits.owner.ConfigCache;
import org.apache.commons.lang3.StringUtils;
import org.bouncycastle.cms.PasswordRecipient;
import org.openqa.selenium.json.Json;

/**
 * @author : zw35
 */
@Slf4j
public class Ticket12306DataFactory {


    public static TicketInfo createTicketData() {
        TicketConfiguration ticketData = ConfigCache.getOrCreate(TicketConfiguration.class);

        return TicketInfo.builder().from(TrainUtil.codeByCity(ticketData.from()))
                .to(TrainUtil.codeByCity(ticketData.to()))
                .date(ticketData.date())
                .trainNumber(ticketData.trainNumber())
                .level(ticketData.lever())
                .passenger(ticketData.passenger())
                .build();
    }
}
