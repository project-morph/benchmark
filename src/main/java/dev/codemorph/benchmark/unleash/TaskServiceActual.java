package dev.codemorph.benchmark.unleash;

import io.getunleash.Unleash;
import java.util.List;
import java.util.UUID;

public class TaskServiceActual {

    private final Unleash unleash;
    private final List<UUID> relevantTaskIds = List.of(UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID());

    public TaskServiceActual(Unleash unleash) {
        this.unleash = unleash;
    }

    /**
     * If feature relevant-tasks is enabled
     *
     * @return list of relevant task ids or otherwise an empty list
     */
    public List<UUID> getRelevantTaskIds() {
        if (unleash.isEnabled("relevant-tasks")) {
            return relevantTaskIds;
        } else {
            return List.of();
        }
    }

}
