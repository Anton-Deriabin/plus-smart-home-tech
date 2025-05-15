package ru.yandex.practicum.telemetry.analyzer.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "scenario_conditions")
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@ToString(exclude = {"scenario", "sensor", "condition"})
@IdClass(ScenarioConditionId.class)
public class ScenarioCondition {

    @Id
    @ManyToOne
    @JoinColumn(name = "scenario_id")
    @EqualsAndHashCode.Include
    Scenario scenario;

    @Id
    @ManyToOne
    @JoinColumn(name = "sensor_id")
    @EqualsAndHashCode.Include
    Sensor sensor;

    @Id
    @ManyToOne
    @JoinColumn(name = "condition_id")
    @EqualsAndHashCode.Include
    Condition condition;
}
