package by.it.group151004.danilov.lesson02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
/*
даны интервальные события events
реализуйте метод calcStartTimes, так, чтобы число принятых к выполнению
непересекающихся событий было максимально.
Алгоритм жадный. Для реализации обдумайте надежный шаг.
*/

public class B_Sheduler {
    //событие у аудитории(два поля: начало и конец)
    static class Event {
        int start;
        int stop;

        Event(int start, int stop) {
            this.start = start;
            this.stop = stop;
        }

        @Override
        public String toString() {
            return "("+ start +":" + stop + ")";
        }
    }

    public static void main(String[] args) {
        B_Sheduler instance = new B_Sheduler();
        Event[] events = {  new Event(0, 3),  new Event(0, 1), new Event(1, 2), new Event(3, 5),
                new Event(1, 3),  new Event(1, 3), new Event(1, 3), new Event(3, 6),
                new Event(2, 7),  new Event(2, 3), new Event(2, 7), new Event(7, 9),
                new Event(3, 5),  new Event(2, 4), new Event(2, 3), new Event(3, 7),
                new Event(4, 5),  new Event(6, 7), new Event(6, 9), new Event(7, 9),
                new Event(8, 9),  new Event(4, 6), new Event(8, 10), new Event(7, 10)
        };

        List<Event> starts = instance.calcStartTimes(events,0,10);  //рассчитаем оптимальное заполнение аудитории
        System.out.println(starts);                                 //покажем рассчитанный график занятий
    }

    static class SortEvent implements Comparator<Event> {
        @Override
        public int compare(Event o1, Event o2) {
            if (o1.start == o2.start && o1.stop == o2.stop) return 0;
            if (o1.start < o2.start) return -1;
            else if (o1.start > o2.start) return 1;
            else if (o1.stop - o1.start < o2.stop - o2.start) return -1;
            else return 1;
        }
    }

    List<Event> calcStartTimes(Event[] events, int from, int to) {
        //events - события которые нужно распределить в аудитории
        //в период [from, int] (включительно).
        //оптимизация проводится по наибольшему числу непересекающихся событий.
        //начало и конец событий могут совпадать.
        List<Event> result;
        result = new ArrayList<>();
        //ваше решение.

        Arrays.sort(events, new SortEvent());

        boolean hasReached = false;
        int i = 0, endTime = from;
        while (!hasReached && i < events.length) {

            // Stop time
            if (events[i].stop > to) hasReached = true;

            // Skip all events before start time
            if (events[i].start < from) {
                i++;
                continue;
            }

            if (events[i].start >= endTime) {
                result.add(events[i]);
                endTime = events[i].stop;
            }

            i++;
        }

        return result;                        //вернем итог
    }
}