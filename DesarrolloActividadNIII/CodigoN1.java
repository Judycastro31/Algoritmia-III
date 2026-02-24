import java.util.*;
public class GraficosTortuga{
static char[][] t=new char[30][30]; 
static int x=0,y=0,d=2,l=0; // Direccion del lapiz 
static char c='*';
static int[] dx={-1,-1,0,1,1,1,0,-1};
static int[] dy={0,1,1,1,0,-1,-1,-1};

public static void main(String[]a){
Scanner s=new Scanner(System.in);
for(int i=0;i<30;i++)for(int j=0;j<30;j++)t[i][j]=' ';
int op;
do{ 
System.out.println("1.Caracter 2.GI 3.GD 4.AV 5.BL 6.SL 7.BO 8.Mostrar 0.Salir");
op=s.nextInt(); 
switch(op){
case 1:c=s.next().charAt(0);break;
case 2:int ai=s.nextInt();if(ai%45==0)d=(d-ai/45+8)%8;break;
case 3:int ad=s.nextInt();if(ad%45==0)d=(d+ad/45)%8;break;
case 4:int p=s.nextInt();for(int i=0;i<p;i++){
int nx=x+dx[d],ny=y+dy[d];
if(nx>=0&&nx<30&&ny>=0&&ny<30){
x=nx;y=ny;
if(l==1)t[x][y]=c;
if(l==2)t[x][y]=' ';
}}break;
case 5:l=1;t[x][y]=c;break;
case 6:l=0;break;
case 7:l=2;break;
case 8:for(int i=0;i<30;i++){for(int j=0;j<30;j++)System.out.print(t[i][j]+" ");System.out.println();}break;
}
}while(op!=0);
}
} 
