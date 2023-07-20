package practice.hospital;

import java.util.Locale;

public class Hospital {

    public static float[] generatePatientsTemperatures(int patientsCount) {
        float[] patientsTemperatures = new float[patientsCount];
        for (int i = 0; i < patientsTemperatures.length; i++) {
            patientsTemperatures[i] = (float) (Math.random() * 8) + 32;
        }
        return patientsTemperatures;
    }

    public static String getReport(float[] temperatureData) {

        int healthyPatientsCount = 0;
        float temperaturesSum = 0;
        String patientsTemperatures = "";

        for (float element : temperatureData) {
            patientsTemperatures = patientsTemperatures.concat(String.format(Locale.US, "%.1f", element))
                    .concat(" ");
            temperaturesSum += element;
            if (element >= 36.2F && element <= 36.9F) {
                healthyPatientsCount++;
            }
        }
        String report =
                "Температуры пациентов: " + patientsTemperatures.trim() + "\nСредняя температура: "
                        + String.format(Locale.US, "%.2f", (temperaturesSum / temperatureData.length)) +
                        "\nКоличество здоровых: " + healthyPatientsCount;
        return report;
    }
}
