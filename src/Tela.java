import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class Tela {
    boolean ligado = true;
    JTextField texto;
    JTextField texto2;
    int x = -150;
    JLabel xxx;
    boolean parado = true;
    private Carro carro;
    private Timer timer;
    JFrame tela;
    public Tela(Carro carro){
        this.carro = carro;
        tela = new JFrame();
        tela.setSize(500, 500);
        tela.setResizable(false);
        tela.setLocation(1400, 0);
        tela.setDefaultCloseOperation(tela.EXIT_ON_CLOSE);
        tela.setLayout(null);

        texto2 = new JTextField("CARRO PARADO.");
        texto2.setBounds(140, 130, 200, 30);
        tela.add(texto2);


        texto = new JTextField("CARRO DESLIGADO.");
        texto.setBounds(140, 100, 200, 30);
        tela.add(texto);
        
        JLabel label1 = new JLabel("SISTEMA DO CARRO");

        label1.setBounds(130, 0, 250, 50);
        label1.setFont(new Font("ARIAL", Font.BOLD, 20));

        JButton botao1 = new JButton("LIGAR");
        botao1.setBounds(20, 350, 100, 40);
        botao1.setBackground(new Color(20, 225, 0));
        botao1.setForeground(new Color(255, 255, 255));
        botao1.setFont(new Font("ARIAL", Font.BOLD, 20));

        tela.add(label1);
        tela.add(botao1);
        
        JButton botao2 = new JButton("ACELERAR");
        botao2.setBounds(200, 350, 200, 40);
        botao2.setBackground(new Color(255, 0, 0));
        botao2.setForeground(new Color(255, 255, 255));
        botao2.setFont(new Font("ARIAL", Font.BOLD, 20));
        
        JButton botao3 = new JButton("PARAR");
        botao3.setBounds(200, 400, 120, 40);
        botao3.setBackground(new Color(20, 0, 255));
        botao3.setForeground(new Color(255, 255, 255));
        botao3.setFont(new Font("ARIAL", Font.BOLD, 20));

        texto.setFont(new Font("ARIAL", Font.BOLD, 12));
        texto2.setFont(new Font("ARIAL", Font.BOLD, 12));

        tela.add(botao3);
        tela.add(botao2);
        botao1.addActionListener(this::ligar);
        botao2.addActionListener(this::acelerar);
        botao3.addActionListener(this::frear);
        
        String img = "C:\\Users\\Pichau\\VSCODE\\brenaoporra - Copia\\brenaoporra - Copia\\src\\image.png";
        ///////////////
        xxx = new JLabel(new ImageIcon(img));
        xxx.setBounds(x, 100, 600, 300);
        tela.add(xxx);


        teclas();
        tela.setVisible(true);
        tela.requestFocusInWindow();
    }

    private void teclas() {
        tela.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    x -= 1;
                    xxx.setBounds(x, 100, 600, 300); // Atualiza a posição da imagem
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    x += 1;
                    xxx.setBounds(x, 100, 600, 300); // Atualiza a posição da imagem
                }
            }
        });
    }
    
    
    
    
    
    
    private void ligar(ActionEvent actionevent1) {
        carro.ligar();
        if (ligado == true){
            texto.setText("CARRO LIGADO!!!!.");
            ligado = false;
        }
        else if (ligado == false){
            ligado = true;
            texto.setText("CARRO DESLIGADO!!!!.");
            texto2.setText("CARRO PARADO!!!.");
            
        
        }
    }

    private void frear(ActionEvent actionevent1) {
        if (ligado == false && parado == false ){
            carro.frear();
            texto2.setText("CARRO FREOU!");
            parado = true;
            if (timer != null) {
                timer.stop(); 
            }
        }
        else {
            System.out.println("Carro ja esta paradoxxxxxxxx");
        }

    }
    

    
    private void acelerar(ActionEvent actionevent1) {
        
        if (ligado == false){
            texto2.setText("CARRO ACELEROU!");
            carro.acelerar();
            parado = false;

            if (timer == null || !timer.isRunning()) {
                timer = new Timer(50, e -> {
                    x += 1; 
                    xxx.setBounds(x, 100, 600, 300);
                });
                timer.start();
            }
        } else {
            System.out.println("Carro está desligado.");
        }
            
        
       

    }
}

