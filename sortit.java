import java.io.*; 
import java.util.*;
public class sortit{
  static list Switch( list curr,list a, list b)
  {
      if(curr==a)
      {
          return curr=b;
          //System.out.println("changed1");
      }
      else 
      {  return curr=a;
         //System.out.println("changed2");
        }
  }
   public static void main(String args[])throws FileNotFoundException
  {
      int fileCount=args.length;
      String prev="";
      list L0=new list();
      list L1=new list();
      list current;//=new list();
      current=L0;
      String str;
      current=Switch(current,L1,L0); //switch returns the right current list 
      for(int i=0;i<fileCount;i++)
      {
          File text=new File(args[i]); 
           if (args[i].equals("-"))
          {
              Scanner userInput = new Scanner(System.in);
              String ans="yes";
               while(ans.equals("yes")||ans.equals("YES")||ans.equals("Yes"))
              {
                  System.out.println("Add a String to be sorted");
                  String userStr=userInput.nextLine();
                  if( prev.compareTo(userStr)>0)
               {
                  current=Switch(current,L0,L1); //current=L1
                  current.insert(userStr); 
                  prev=userStr;
                }
                else 
                {
                    current.insert(userStr); //current=L0
                    prev=userStr; 
                }
                System.out.println("Do you want to add another String? If yes type yes,else no");
                
                 ans=userInput.next();
              }
          }
          else
          {
           Scanner scan=new Scanner(text);
            while (scan.hasNextLine())
           {
              str=scan.nextLine();
              if( prev.compareTo(str)>0)
               {
                  current=Switch(current,L0,L1); //current=L1
                  current.insert(str); 
                  prev=str;
                }
                else 
                {
                    current.insert(str); //current=L0
                    prev=str; 
                }
            }
         }
      }
      
          String L0Head;
          String L1Head;
          int L0Count=L0.returnSize(); 
          int L1Count=L1.returnSize(); 
          current=L0; 
          prev="";
         while ((L1.isEmpty()!=true) && (L0.isEmpty()!=true))
         {
                  L0Count=L0.returnSize(); 
                  L1Count=L1.returnSize(); 
                  prev="";
                while((L0Count!=0 || L1Count!=0))
                {
                     if(L0Count==0)
                     {
                         L1Head=L1.top();
                         if(L1Head.compareTo(prev)>0)
                         {
                             current.insert(L1Head); 
                             L1Count--;
                             prev=L1Head; 
                             L1.pop();    
                         }
                         else
                            {
                                current=Switch(current,L0,L1);
                                current.insert(L1Head);
                                L1Count--;
                                prev=L1Head; 
                                L1.pop(); 
                      
                            }
                     }
                     else if (L1Count==0)
                     {
                         L0Head=L0.top();
                         if(L0Head.compareTo(prev)>0)
                         {
                             current.insert(L0Head); 
                             L0Count--;
                             prev=L0Head; 
                             L0.pop(); 
                         }
                         else
                            {
                                current=Switch(current,L0,L1);
                                current.insert(L0Head);
                                L0Count--;
                                prev=L0Head; 
                                L0.pop(); 
                      
                            }
                     }
                     else if (L0Count!=0 && L1Count!=0)
                     {
                          L0Head=L0.top();
                          L1Head=L1.top();
                          if( (prev.compareTo(L0Head)<=0) && (prev.compareTo(L1Head)<=0))
                          {
                            if((L1Head.compareTo(L0Head)<0))
                            {
                             current.insert(L1Head);
                             L1Count--;
                             prev=L1Head; 
                             L1.pop(); 
                            }
                            else
                            {
                             current.insert(L0Head);
                             L0Count--;
                             prev=L0Head; 
                             L0.pop(); 
                            }
                          }
                       else if((prev.compareTo(L0Head)<=0) || (prev.compareTo(L1Head)<=0))
                           {
                            if((L1Head.compareTo(L0Head)>0))
                            {
                                current.insert(L1Head); 
                                L1Count--;
                                prev=L1Head; 
                                L1.pop(); 
                            }
                            else
                            {
                                current.insert(L0Head);
                                L0Count--;
                                prev=L0Head; 
                                L0.pop(); 
                      
                            }
                          }
                        else if((prev.compareTo(L0Head)>0) && (prev.compareTo(L1Head)>0))//need to put condition here in order to not be executed all the time 
                          {  
                            current=Switch(current,L0,L1);
                            if((L1Head.compareTo(L0Head)<0))
                            {
                             current.insert(L1Head);
                             L1Count--;
                             prev=L1Head; 
                             L1.pop(); 
                            }
                            else
                            {
                             current.insert(L0Head);
                             L0Count--;
                             prev=L0Head; 
                             L0.pop(); 
                            }
                         }
                     }
                  }
            }
         //System.out.println("Sorted Strings:");
         if (L0.isEmpty())
         {
             L1.print();
         }
         else 
            L0.print();
       }
        
}
  
      
      
      
      
        
      
      
      
      
      

    
      
  


