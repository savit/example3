import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class My32 {
	public static void main(String[] args) {
		MyFrame frame=new MyFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.show();
	}
}

//создание окна
class MyFrame extends JFrame{
	public MyFrame(){
		setTitle("Окно программы");
		setSize(300,200);
		MyPanel panel=new MyPanel();
		Container pane=getContentPane();
		pane.add(panel);
	}
}

//содание в окне панели
class MyPanel extends JPanel{
	//конструктор панели
	public MyPanel(){
		makeButton("желтая кнопка",Color.yellow);
		makeButton("красная кнопка",Color.red);
		makeButton("зеленая кнопка",Color.green);
	}
	//метод добавления кнопки
	void makeButton(String name, Color c){
		JButton button=new JButton(name);//создание кнопки
		add(button);//добавление кнопки на панель
		MyAction myAction = new MyAction(c);//создаем событие на основе класса
		button.addActionListener(myAction);//связывем его с кнопкой
	}
	
	//ActionListener - интерфейс стандартного обработчика событий Java
	private class MyAction implements ActionListener{
		private Color backgroundColor;
		public MyAction(Color c){			
			backgroundColor=c;
		}
		@Override
		public void actionPerformed(ActionEvent e) {//Реакция программы на событие
			if (backgroundColor==Color.red)
				JOptionPane.showMessageDialog(null, "Цвет?");
			setBackground(backgroundColor);
		}
	}
}