import java.awt. *;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
//import java.io.IOException;
//import javax.swing.JFileChooser;
import javax.swing.*;
//import javax.swing.text.JTextComponent;
public class Jsb extends JFrame{
	 Da d ;
	 JCheckBoxMenuItem a55;
	 JPopupMenu pp;
     @SuppressWarnings("deprecation")
	public Jsb() {
    	 super("记事本");
    	    	
    	    	 
    	// JMenu a2;
    	setVisible(true);
     
    	setSize(600,600);
     
    	//JPanel b=new JPanel();
    	 
    	//b.setBackground(Color.white);
    	 pp=new JPopupMenu();
    	  JTextArea c1=new  JTextArea();
    	 JScrollPane c=new JScrollPane(c1); 
    	 //add(b);
    	 add(c);
    	 d=new Da();
    	  JPopupMenu h=new JPopupMenu();
    	  h.setVisible(true);
    	  //c1.add(h);
    	 JMenuBar a1=new JMenuBar();
    	 a1.setBackground(Color.white);
    	 JMenu a2=new JMenu("文件（F）");
    	 a2.setMnemonic(KeyEvent.VK_F);
    	  JMenu a3=new JMenu("编辑（E）");
    	 JMenu a4=new JMenu("格式（O）");
    	 JMenu a5=new JMenu("查看（V）");
    	 JMenu a6=new JMenu("帮助（H）");
    	 setJMenuBar(a1);
    	 a1.add(a2);
    	 a1.add(a3);
    	 a1.add(a4);
    	 a1.add(a5);
    	 a1.add(a6);
    	 JMenuItem b1=new JMenuItem ("新建 (N)");
    	 JMenuItem b5=new JMenuItem ("打开 (O)");
    	 JMenuItem b2=new JMenuItem ("保存 (S)");
    	 JMenuItem b3=new JMenuItem ("lin存为");
    	 JMenuItem b4=new JMenuItem ("页面设置");
    	 JMenuItem b6=new JMenuItem ("打印");
    	 JMenuItem b7=new JMenuItem ("退出");
    	 JMenuItem b8=new JMenuItem ("查看帮助");
    	 JMenuItem b9=new JMenuItem ("关于记事本");
    	 JMenuItem b10=new JMenuItem ("撤销（U）");
    	 JMenuItem b11=new JMenuItem ("剪切（T）");
    	 JMenuItem b12=new JMenuItem ("复制（C）");
    	 JMenuItem b13=new JMenuItem ("粘贴（P）");
    	 JMenuItem b14=new JMenuItem ("删除（L）");
    	 JMenuItem b15=new JMenuItem ("字体颜色");
    	 JMenuItem b16=new JMenuItem ("字体格式");
    	 a55=new JCheckBoxMenuItem("状态栏");
    	 h.add(b1);
    	 a2.add(b1);
    	 a2.add(b5);
    	 a2.add(b2);    	
    	 a2.add(b3);
    	 a2.addSeparator();
    	 a2.add(b4);
    	 a2.add(b6);
    	 a2.addSeparator();
    	 a2.add(b7);
    	 a6.add(b8);
    	 a6.add(b9);
    	  a5.add(a55);
    	 a3.add(b10);
    	 a3.addSeparator();
    	 a3.add(b11);
    	 a3.add(b12);
    	 a3.add(b13);
    	 a3.add(b14);
    	 a4.add(b15);
    	 a4.add(b16);
    	 pp=a3.getPopupMenu();
    	 setIconImage((new ImageIcon("bh/hh.PNG")).getImage());  	 
    	  b1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,KeyEvent.CTRL_MASK));
    	  b5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,KeyEvent.CTRL_MASK));
    	  b2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,KeyEvent.CTRL_MASK));
    	  
    	 b9.addMouseListener( new MouseAdapter() {
		 			@Override
			public void mousePressed(MouseEvent arg0) {
		 				 d.setVisible(true);// TODO Auto-generated method stub
				super.mousePressed(arg0);
			}				 
    	 });
    	 
    	 b1.addActionListener(new ActionListener(){			 
			@Override
			public void actionPerformed(ActionEvent arg0) {
				 c1.setText("");				 				 
							}    		 
    	   });    	    	 
    	 
    	 b7.addMouseListener( new MouseAdapter() {
			   public void mousePressed(MouseEvent arg0) {
				 		 	System.exit(1);
				 		 	
			}
    	 });
    	 
    	 b15.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Color ys=JColorChooser.showDialog(null, "", Color.black);// TODO Auto-generated method stub
				c1.setForeground(ys);
				 
			}});
    	 
       b5.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent arg0) {
			c1.setText("");
			JFileChooser fc=new JFileChooser( );
			try{
			if(fc.showOpenDialog(getComponent(0))==JFileChooser.APPROVE_OPTION){
			String fn = fc.getSelectedFile( ).getAbsolutePath( );
			FileReader fr = new FileReader(fn);  
			BufferedReader br=new BufferedReader(fr);  
			String s="";
			while((s=br.readLine( ))!=null){
			c1.append(s+"\n");
			}
			br.close( );
			fr.close( );
			}
			}
			catch(Exception ex){
			System.out.print(ex.toString( ));
			}						
		}});
       
    b2.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent arg0) {
			JFileChooser fc=new JFileChooser( ); 
			try{
			if(fc.showSaveDialog(getComponent(0))==JFileChooser.APPROVE_OPTION){
			String fn = fc.getSelectedFile( ).getAbsolutePath( );
			FileWriter fw=new FileWriter(fn);  
			BufferedWriter bw=new BufferedWriter(fw);  
			String s =c1.getText( );
			bw.write(s);
			bw.close( );
			fw.close( );
			}
			}
			catch(Exception ex){
			System.out.print(ex.toString( ));
			}
		}});
    
        c1.addMouseListener( new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 if(e.getButton()==MouseEvent.BUTTON3)
				 pp.show(a3,e.getX(), e.getY());
				 if(e.getButton()==MouseEvent.BUTTON1)
					 pp.setVisible(false);
			}});
        
        b11.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				c1.cut();// TODO Auto-generated method stub				
			}});
        
        b12.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				c1.copy();// TODO Auto-generated method stub				
			}});
        
        b13.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				c1.paste();// TODO Auto-generated method stub				
			}});
        
     }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new Jsb();
   }
}
     class Da extends JDialog{
	  JLabel l1,l2,l3;
	  JPanel p1,p2,p3;
	  JButton j;
	  public Da() {
		  setTitle("关于“记事本”");
	    	setSize(650, 500);
	    	setLocation(400,200);
	    	p1=new JPanel();
	    	p2=new JPanel();
	    	add(p1,"North");
	    	add(p2,"Center");
	    	l2=new JLabel(new ImageIcon("bh/cc.PNG"));	    	 
	    	p1.add(l2);
	    	l1=new JLabel(new ImageIcon("bh/aa.PNG"));
	    	p2.add(l1);
	    	p3=new JPanel();
	    	add(p3,"South");
	    	l3=new JLabel("制作者：范勇杰        制作时间：2018年11月");
	    	j=new JButton("确定");
	    	p3.add(l3);
	    	p3.add(j);
	    	j.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					 setVisible(false); 
				}});
	  }
	protected void closeFile() {
		// TODO Auto-generated method stub
		
	}
  } 
