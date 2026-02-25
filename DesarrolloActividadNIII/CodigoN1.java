import java.util.*;
import java.io.*;

public class GraficosTortuga{
static char[][] t=new char[30][30]; 
static int x=0,y=0,d=2,l=0; // Direccion del lapiz 
static char c='*';
static int[] dx={-1,-1,0,1,1,1,0,-1};
static int[] dy={0,1,1,1,0,-1,-1,-1};

static ArrayList<String> instrucciones=new ArrayList<>();
  
public static void main(String[]a){
Scanner s=new Scanner(System.in);
for(int i=0;i<30;i++)for(int j=0;j<30;j++)t[i][j]=' ';
int op;
do{ 
  
System.out.println("\n===== MENÚ Autores; Judy y Andres =====");
            System.out.println("1. Elegir Caracter");
            System.out.println("2. Girar Izquierda (GI)");
            System.out.println("3. Girar Derecha (GD)");
            System.out.println("4. Avanzar (AV)");
            System.out.println("5. Levantar Lapiz (BL)");
            System.out.println("6. Bajar Lapiz (SL)");
            System.out.println("7. Borrar (BO)");
            System.out.println("8. Mostrar Tablero");
            System.out.println("9. Ver Instrucciones");
            System.out.println("10. Guardar Instrucciones");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
  
op=s.nextInt(); 
s.nextLine();
  
 switch(op){
                case 1:
                    c=s.next().charAt(0);
                    instrucciones.add("Caracter "+c);
                    break;
                case 2:
                    int ai=s.nextInt();
                    if(ai%45==0)d=(d-ai/45+8)%8;
                    instrucciones.add("GI "+ai);
                    break;
                case 3:
                    int ad=s.nextInt();
                    if(ad%45==0)d=(d+ad/45)%8;
                    instrucciones.add("GD "+ad);
                    break;
                case 4:
                    int p=s.nextInt();
                    instrucciones.add("AV "+p);
                    for(int i=0;i<p;i++){
                        int nx=x+dx[d],ny=y+dy[d];
                        if(nx>=0&&nx<30&&ny>=0&&ny<30){
                            x=nx;y=ny;
                            if(l==1)t[x][y]=c;
                            if(l==2)t[x][y]=' ';
                        }
                    }
                    break;
                case 5:
                    l=1;t[x][y]=c;
                    instrucciones.add("BL");
                    break;
                case 6:
                    l=0;
                    instrucciones.add("SL");
                    break;
                case 7:
                    l=2;
                    instrucciones.add("BO");
                    break;
                case 8:
                    for(int i=0;i<30;i++){
                        for(int j=0;j<30;j++)System.out.print(t[i][j]+" ");
                        System.out.println();
                    }
                    break;
                case 9:
                    for(String ins:instrucciones)System.out.println(ins);
                    break;
                case 10:
                    try{
                        PrintWriter pw=new PrintWriter("instrucciones.txt");
                        for(String ins:instrucciones)pw.println(ins);
                        pw.close();
                        System.out.println("Guardado correctamente");
                    }catch(Exception e){System.out.println("Error al guardar");}
                    break;
            }
        }while(op!=0);
    }

    public static ArrayList<String> getInstrucciones() {
        return instrucciones;
    }
}
