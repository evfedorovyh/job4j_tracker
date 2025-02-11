package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double result = 0;
        int amountScores = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                result += subject.score();
                amountScores++;
            }
        }
        return result / amountScores;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double sumScores = 0;
            int amountScores = 0;
            for (Subject subject : pupil.subjects()) {
                sumScores += subject.score();
                amountScores++;
            }
            result.add(new Label(pupil.name(), sumScores / amountScores));
        }
        return result;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        int amountOfPupils = pupils.size();
        Map<String, Integer> sumScoresBySubject = new HashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sumScoresBySubject.merge(subject.name(), subject.score(), Integer::sum);
            }
        }
        for (String key : sumScoresBySubject.keySet()) {
            result.add(new Label(key, (double) sumScoresBySubject.get(key) / amountOfPupils));
        }
        return result;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double sumScores = 0;
            for (Subject subject : pupil.subjects()) {
                sumScores += subject.score();
            }
            result.add(new Label(pupil.name(), sumScores));
        }
        result.sort(Comparator.naturalOrder());
        return result.get(result.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        Map<String, Integer> sumScoresBySubject = new HashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sumScoresBySubject.merge(subject.name(), subject.score(), Integer::sum);
            }
        }
        for (String key : sumScoresBySubject.keySet()) {
            result.add(new Label(key, sumScoresBySubject.get(key)));
        }
        result.sort(Comparator.naturalOrder());
        return result.get(result.size() - 1);
    }
}
