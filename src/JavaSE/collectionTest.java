package JavaSE;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

    class Person {
        private String name;
        private Integer age;

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return Objects.equals(name, person.name) &&
                    Objects.equals(age, person.age);
        }

        @Override
        public int hashCode() {

            return Objects.hash(name, age);
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }


    public class collectionTest {

        public static void main(String[] args) {
            List<Person> list = new ArrayList<Person>();
            Stream<Person> stream = list.stream();
            list.add(new Person("haha", 12));
            list.add(new Person("xixi", 13));
            list.add(new Person("hehe", 14));
            System.out.println(list);
            System.out.println(list.contains(new Person("xixi", 13)));
            Map<Integer, String> map = new HashMap<>();
            map.put(0, "a");
            map.put(1, "b");
            map.put(2, "c");
            map.put(3, "d");
            map.put(null, null);
            map.put(null, null);
            map.put(4, null);
            map.put(5, null);
            System.out.println(map);
            System.out.println("values------");
            System.out.println(map.values());
            System.out.println("key-------");
            System.out.println(map.keySet());
            //1.Map->Set
            Set<Map.Entry<Integer, String>> key = map.entrySet();
            //2.取得Set迭代器
            Iterator<Map.Entry<Integer, String>> iterator = key.iterator();
            //3.迭代输出
            while (iterator.hasNext()) {
                Map.Entry<Integer, String> entry = iterator.next();
                System.out.println(entry.getKey() + "=" + entry.getValue());
            }
        }
    }
