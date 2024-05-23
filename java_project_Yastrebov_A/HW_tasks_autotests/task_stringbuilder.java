package HW_tasks_autotests;

import java.security.PublicKey;

public class task_stringbuilder {
    public static StringBuilder answer (String QUERY, String PARAMS) {
        String prepare = PARAMS
        .replace("{", "").replace("}", "").replace("\"", "");

        String name = prepare.split(",") [0].split(":")[1];
        String country = prepare.split(",") [1].split(":")[1];
        String city = prepare.split(",") [2].split(":")[1];
        String age = prepare.split(",") [3].split(":")[1];

        StringBuilder result = new StringBuilder(QUERY);

        if (name.equals("null")){
    result.append("name=").append("'").append(name).append("'");

        }
        if (!name.equals("null")){
            result.append (" and ");
        }


        
        return result;
    }

    

}
