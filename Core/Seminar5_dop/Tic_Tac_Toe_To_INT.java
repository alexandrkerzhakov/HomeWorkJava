package GeekBrains.Core.Seminar5_dop;

import java.nio.ByteBuffer;

/*
(*) ������������, ��� ����� � �������� ������� �� 9 ��������� ����� ��������[0, 3], � ������������ �����,
��������, ��������� ����� ���� ��� ���� � ��������������, ��� 0 � ��� ������ ����, 1 � ��� ���� � ���������, 2 � ��� ���� � �������,3 � ��������� ��������.
����� ������������� �������� ������� � ����� ����� ���� int �� ���� 3�3. �������� � ���� 9 �������� ���, ����� ��� ������ ��� �����.
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
