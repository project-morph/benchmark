package dev.codemorph.benchmark.unleash;

import java.util.List;
import java.util.UUID;

public class TaskServiceActual {

    private final List<UUID> relevantTaskIds = List.of(UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID());

    /**
     * If feature relevant-tasks is enabled
     *
     * @return list of relevant task ids or otherwise an empty list
     */
    public List<UUID> getRelevantTaskIds() {
        if (FeatureFlags.isFlagEnabled("relevant-tasks")) {
            return relevantTaskIds;
        } else {
            return List.of();
        }
    }

}
