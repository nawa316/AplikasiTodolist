
package belajar.aplikasitodolist;

/**
 *
 * @author users_gc6i8
 */
public class AplikasiTodolist {
    
    public static String[] model = new String[10];
    
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        viewShowTodolist();
    }
    
    //menampilkan Todolist
    public static void showTodolist(){
        for (var i = 0; i < model.length; i++){
            var todo = model[i];
            var no = i + 1;
            
            if(todo != null){
                System.out.println(no + ". " + todo);
            }
        }  
    }
    
    /*
    public static void testShowTodolist(){
        
        model[0]= "satu";
        model[1]= "dua";
        model[2]= "tiga";
               
        showTodolist();
    } */

    
    //menambah Todolist
    public static void addTodolist(String todo){
        //cek apakah model penuh?
        var isFull = true;
        for(var i = 0; i < model.length; i++){
            if (model[i] == null){
                //model masih kosong
                isFull = false;
                break;
            }
        }
        
        //Jika penuh, kita resize ukuran array 2x lipat
        if (isFull){
            var temp = model;
            model = new String[model.length *2];
            //copy data array sebelumnya ke temp
            for (var i = 0; i < temp.length; i++){
                model[i] = temp[i];
            }
        }
        
        //tambahkan ke posisi yang data array nya NULL
        for(var i = 0; i < model.length; i++){
            if (model[i] == null){
                model[i] = todo;
                break;
            }    
        }   
    }
    
    /*
    public static void testAddTodolist(){
        model[0] = "satu";
        model[1] = "dua";
        model[2] = "tiga";
        
        for(var i = 0; i < 30; i++){
            addTodolist("Menambah Todolist ke-" + i);  
    }
        
        showTodolist();
        
    } */
    
    //menghapus Todolist
    public static boolean removeTodolist(Integer number){
        if ((number-1)>= model.length){
            return false;
        } else if (model[number-1] == null){
            return false;
        } else {
        for (var i = (number - 1); i < model.length; i++){
            if (i == (model.length - 1)){
                model[i] = null; // menghapus data di ujung array
            } else {
                model[i] = model[i + 1]; //menggeser data dari setelahnya
                }
            }
        }
        return true;
    }
    
    /*
    public static void testRemoveTodolist(){
        model[0] = "Satu";
        model[1] = "Dua";
        model[2] = "tiga";
        model[3] = "Empat";
        
        removeTodolist(1);
        
        showTodolist();
    } */
    
    // method input menyimpan ke data
    public static String input(String info){
        System.out.print(info + ": ");
        String data = scanner.nextLine();
        return data;
    }
    
    
    public static void testInput(){
        var nama = input("nama");
        System.out.println("Hi " + nama);
    } 
            
    // Menampilkan halaman Todolist
    public static void viewShowTodolist(){
        while(true){
            System.out.println("TODOLIST");
            
            showTodolist();
            System.out.println("MENU:");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. keluar");
            
            var input = input("Pilih");
            
            if(input.equals("1")){
                viewAddTodolist();
            } else if (input.equals("2")){
                viewRemoveTodolist();
            } else if (input.equals("x")){
                break;
            } else {
                System.out.println("Pilihan tidak dimengerti");
            }
        }
    }
    
    /*
    public static void testViewShowTodolist(){
        addTodolist("satu");
        addTodolist("dua");
        addTodolist("tiga");
        viewShowTodolist();
    }*/
    
    public static void viewAddTodolist(){
        System.out.println("MENAMBAH TODOLIST");
        
        var todo = input("Todo (x untuk batal)");
        if(todo.equals("x")){
            //batal
        } else {
            addTodolist(todo);
        }
        
    }
    
    /*
    public static void testViewAddTodolist(){
       addTodolist("satu");
       addTodolist("dua");
       addTodolist("tiga");
       viewAddTodolist();
    }*/
    
    public static void viewRemoveTodolist(){
        System.out.println("MENGHAPUS TODOLIST");
        
        var number = input ("Nomor yang akan dihapus(x untuk batal)");
        if (number.equals("x")){
            //batal
        } else {
            boolean succes = removeTodolist(Integer.valueOf(number));
            if (!succes){
                System.out.println("Gagal menghapus todolist:" + number);
            }
        }
        
    }
    
     /*
    public static void testViewRemoveTodolist(){
       addTodolist("satu");
       addTodolist("dua");
       addTodolist("tiga");
       viewRemoveTodolist();
    }*/
    
}
