import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashSet<String> hash = new HashSet<>();
        
        for(String key : phone_book){
            hash.add(key);
        }
        
        for(String key: phone_book){
            for(int i = 0; i<key.length(); i++){
                if(hash.contains(key.substring(0, i))){
                    return false;
                }
            }
            
        }
        return true;
        
    }
}