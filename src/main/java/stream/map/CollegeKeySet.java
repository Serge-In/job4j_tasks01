package stream.map;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * 2024-03-24
 * 17. Путь от циклов к Stream API. [#24260]
 * рассмотрим примеры использования методов Stream API для коллекций типа Map.
 * Поскольку Map не является наследником интерфейса Collection, то в Map не определен метод stream()
 * - соответственно мы не можем получить поток значений напрямую.
 * Однако у Map есть метод keySet(), который возвращает набор всех ключей в виде коллекции типа Set.
 * Добавим 2 модели данных - Student и Subject
 * Давайте рассмотрим простую задачу поиска данных, реализация будет через циклы (потом перепишем на использование Stream API).
 *
 * Реализуем класс College, в котором будет 2 метода поиска студента по аккаунту,
 * а также поиск предмета по аккаунту и имени предмета (сделаем это с помощью циклов):
 *
 * Теперь перепишем наши методы с применением Stream API -
 * поскольку мы используем keySet(), то у нас получается коллекция,
 * у которой доступен метод stream() именно так мы откроем поток объектов Student.
 * Чтобы заменить блок if() мы будем использовать метод filter(), который принимает предикат
 * В качестве терминальной операции будем использовать findFirst() - метод возвращает результат в виде объекта типа Optional
 * cм. класс College2
 */
public class CollegeKeySet {
        private final Map<Student, Set<Subject>> students;

        public CollegeKeySet(Map<Student, Set<Subject>> students) {
            this.students = students;
        }

        public Student findByAccount(String account) {
//            for (Student student : students.keySet()) {
//                if (student.account().equals(account)) {
//                    return student;
//                }
//            }
//            return null;

            Optional<Student> res = students.keySet()
                    .stream()
                    //.filter(student -> account.equals(Student::getAccount)) // так не работает
                    //.filter(student -> account.equals(student.getAccount())) // если есть геттер
                    .filter(student -> account.equals(student.account())) // если нет геттера
                    .findFirst();

            return res.orElse(null); // при возврате null будет ошибка, тк ожидается Student
        }

        public Subject findBySubjectName(String account, String name) {
//            Student student = findByAccount(account);
//            if (student != null) {
//                Set<Subject> subjects = students.get(student);
//                for (Subject subject : subjects) {
//                    if (subject.name().equals(name)) {
//                        return subject;
//                    }
//                }
//            }
//            return null;

            Student student = findByAccount(account);
            if (student == null) {
                return null;
            }
            return students.get(student)
                        .stream()
                        .filter(subject -> subject.name().equals(name))
                        .findFirst()
                        .orElse(null);

        }

        public static void main(String[] args) {
            Map<Student, Set<Subject>> students = Map.of(new Student("Student", "000001", "201-18-15"),
                    Set.of(
                            new Subject("Math", 70),
                            new Subject("English", 85)
                    )
            );
            stream.map.CollegeKeySet college = new stream.map.CollegeKeySet(students);
            Student student = college.findByAccount("000001");

            System.out.println(student.getClass()); //class stream.map.Student
            System.out.println("Найденный студент: " + student); //Найденный студент: Student[name=Student, account=000001, group=201-18-15]

            Subject english = college.findBySubjectName("000001", "English");
            System.out.println(english.getClass()); //class stream.map.Subject
            System.out.println("Оценка по найденному предмету: " + english.score()); //Оценка по найденному предмету: 85
        }

}
