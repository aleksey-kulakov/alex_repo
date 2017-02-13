package ua.itea.javaAdvanced.practice.lesson03.SetMath;

import java.util.HashSet;
import java.util.Set;

public class SetMath<T> {

    public Set<T> setUnion(Set<T> set1, Set<T> set2){
        Set<T> resultSet = new HashSet<>();
        for(T x : set1){
            resultSet.add(x);
        }
        for(T x : set2){
            resultSet.add(x);
        }
        return resultSet;
    }

    public Set<T> setIntersection(Set<T> set1, Set<T> set2){
        Set<T> resultSet = new HashSet<>();
        for(T x : set1){
            if (set2.contains(x)){
                resultSet.add(x);
            }
        }
        for(T x : set2){
            if (set1.contains(x)){
                resultSet.add(x);
            }
        }
        return resultSet;
    }

    public Set<T> setDifference(Set<T> set1, Set<T> set2){
        Set<T> resultSet = new HashSet<>();
        for(T x : set1){
            if (!set2.contains(x)){
                resultSet.add(x);
            }
        }
        for(T x : set2){
            if (!set1.contains(x)){
                resultSet.add(x);
            }
        }
        return resultSet;
    }
}
