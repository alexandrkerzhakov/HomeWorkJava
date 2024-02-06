package GeekBrains.Core.Seminar5_dop;

import java.nio.ByteBuffer;

/*
(*) ѕредположить, что числа в исходном массиве из 9 элементов имеют диапазон[0, 3], и представл€ют собой,
например, состо€ни€ €чеек пол€ дл€ игры в крестикинолики, где 0 Ц это пустое поле, 1 Ц это поле с крестиком, 2 Ц это поле с ноликом,3 Ц резервное значение.
“акое предположение позволит хранить в одном числе типа int всЄ поле 3х3. «аписать в файл 9 значений так, чтобы они зан€ли три байта.
 */

public class Tic_Tac_Toe_To_INT {
    public static void main(String[] args) {
        byte[] tic_tac_toe = new byte[4];

        tic_tac_toe[0] = 102;
        tic_tac_toe[1] = 111;
        tic_tac_toe[2] = 001;

        ByteBuffer buffer = ByteBuffer.allocate(Integer.BYTES);
        buffer.put(tic_tac_toe);
        buffer.rewind();
        int value = buffer.getInt();
        System.out.println(value);
    }
}
