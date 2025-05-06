package ru.yandex.practicum.telemetry.collector.mapper;

import ru.yandex.practicum.kafka.telemetry.event.*;
import ru.yandex.practicum.telemetry.collector.model.sensor.*;

public class SensorEventMapper {

    public static SensorEventAvro toAvro(SensorEvent event) {
        long timestamp = event.getTimestamp().toEpochMilli();

        if (event instanceof TemperatureSensorEvent temp) {
            TemperatureSensorAvro payload = TemperatureSensorAvro.newBuilder()
                    .setId(temp.getId())
                    .setHubId(temp.getHubId())
                    .setTimestamp(timestamp)
                    .setTemperatureC(temp.getTemperatureC())
                    .setTemperatureF(temp.getTemperatureF())
                    .build();

            return SensorEventAvro.newBuilder()
                    .setId(temp.getId())
                    .setHubId(temp.getHubId())
                    .setTimestamp(timestamp)
                    .setPayload(payload)
                    .build();
        }

        if (event instanceof LightSensorEvent light) {
            LightSensorAvro payload = LightSensorAvro.newBuilder()
                    .setLinkQuality(light.getLinkQuality())
                    .setLuminosity(light.getLuminosity())
                    .build();

            return SensorEventAvro.newBuilder()
                    .setId(light.getId())
                    .setHubId(light.getHubId())
                    .setTimestamp(timestamp)
                    .setPayload(payload)
                    .build();
        }

        if (event instanceof MotionSensorEvent motion) {
            MotionSensorAvro payload = MotionSensorAvro.newBuilder()
                    .setLinkQuality(motion.getLinkQuality())
                    .setMotion(motion.isMotion())
                    .setVoltage(motion.getVoltage())
                    .build();

            return SensorEventAvro.newBuilder()
                    .setId(motion.getId())
                    .setHubId(motion.getHubId())
                    .setTimestamp(timestamp)
                    .setPayload(payload)
                    .build();
        }

        if (event instanceof SwitchSensorEvent sw) {
            SwitchSensorAvro payload = SwitchSensorAvro.newBuilder()
                    .setState(sw.isState())
                    .build();

            return SensorEventAvro.newBuilder()
                    .setId(sw.getId())
                    .setHubId(sw.getHubId())
                    .setTimestamp(timestamp)
                    .setPayload(payload)
                    .build();
        }

        if (event instanceof ClimateSensorEvent climate) {
            ClimateSensorAvro payload = ClimateSensorAvro.newBuilder()
                    .setTemperatureC(climate.getTemperatureC())
                    .setHumidity(climate.getHumidity())
                    .setCo2Level(climate.getCo2level())
                    .build();

            return SensorEventAvro.newBuilder()
                    .setId(climate.getId())
                    .setHubId(climate.getHubId())
                    .setTimestamp(timestamp)
                    .setPayload(payload)
                    .build();
        }

        throw new IllegalArgumentException("Unsupported event type: " + event.getClass().getSimpleName());
    }
}
