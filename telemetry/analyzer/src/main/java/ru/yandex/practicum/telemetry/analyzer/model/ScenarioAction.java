package ru.yandex.practicum.telemetry.analyzer.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "scenario_actions")
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@ToString(exclude = {"scenario", "sensor", "action"})
@IdClass(ScenarioActionId.class)
public class ScenarioAction {

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
    @JoinColumn(name = "action_id")
    @EqualsAndHashCode.Include
    Action action;
}
