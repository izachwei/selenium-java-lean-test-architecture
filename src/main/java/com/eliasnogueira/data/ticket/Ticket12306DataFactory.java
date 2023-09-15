package com.eliasnogueira.data.ticket;

import java.util.HashMap;
import java.util.Map;

import com.eliasnogueira.model.TicketInfo;
import lombok.extern.slf4j.Slf4j;
import org.aeonbits.owner.ConfigCache;
import org.apache.commons.lang3.StringUtils;

/**
 * @author : zw35
 */
@Slf4j
public class Ticket12306DataFactory {

    private static Map<String, String> stationMap = new HashMap<>(2048);
    private static TicketConfiguration ticketConfiguration;

    static {
        ticketConfiguration = ConfigCache.getOrCreate(TicketConfiguration.class);
        String stationStr = ticketConfiguration.stationStr();
        if (StringUtils.isEmpty(stationStr)) {
            stationStr = loadStationByApi(ticketConfiguration.stationLink());
        }
        parseStationStr(stationStr, stationMap);
    }

    private static void parseStationStr(String stationStr, Map<String, String> stationMap) {
        String[] split = stationStr.split("\\|\\|\\|@");
        for (String station : split) {
            String[] current = station.split("\\|");
            stationMap.put(current[1], current[2]);
        }
    }

    private static String loadStationByApi(String s) {
        return "";
    }

    public static TicketInfo createTicketData() {
        return TicketInfo.builder().to(
                stationMap.getOrDefault(ticketConfiguration.to(), ticketConfiguration.to()))
            .from(stationMap.getOrDefault(ticketConfiguration.from(), ticketConfiguration.from()))
            .date(ticketConfiguration.date())
            .level(ticketConfiguration.lever()).build();
    }
}
