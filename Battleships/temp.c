#include <stdio.h>

int main() {
	char field[11][11];
	
	for (int i = 0; i < 11; i++) {
		for (int j = 0; j < 11; j++) {
			if(i == 0 && j == 0) field[i][j] = ' ';
			else {
				if(i == 0 && j > 0) field[i][j] = 65+j-1;
				else if(j == 0 && i > 0) field[i][j] = 49+i-2;
				else field[i][j] = ' ';
			}
		}
	}

	 /* BURALARI JAVAYA CLASSA UYARLA*/
	 // FOR ADMIRAL
	 for (int i = 0; i < 1; i++) {
		char inp1, inp2;
	 	printf("Amiral geminizi yerleştiriniz: (örn: A5) ");
	 	scanf("%c%c", &inp1, &inp2);
	 	field[inp2-48][inp1-65+1] = 'A';
	 }
	 // FOR KREUZERS
	 for (int i = 0; i < 2; i++) {
	 	char inp1, inp2;
	 	printf("%d. krevazör geminizi yerleştiriniz: (örn: A5) ",i+1);
	 	scanf("%c%c", &inp1, &inp2);
	 	field[inp2-48][inp1-65+1] = 'K';
	 }
	 // FOR DESTROYER
	 for (int i = 0; i < 3; i++) {
	 	char inp1, inp2;
	 	printf("%d. muhrip geminizi yerleştiriniz: (örn: A5) ",i+1);
	 	scanf("%c%c", &inp1, &inp2);
	 	field[inp2-48][inp1-65+1] = 'D';
	 }
	 // FOR SUBMARINE
	 for (int i = 0; i < 4; i++) {
	 	char inp1, inp2;
	 	printf("%d. denizaltınızı yerleştiriniz: (örn: A5) ",i+1);
	 	scanf("%c%c", &inp1, &inp2);
	 	field[inp2-48][inp1-65+1] = 'S';
	 }
	 // FOR TRAPS
	 for (int i = 0; i < 1; i++) {
	 	char inp1, inp2;
	 	printf("%d. tuzağınızı yerleştiriniz: (örn: A5) ",i+1);
	 	scanf("%c%c", &inp1, &inp2);
	 	field[inp2-48][inp1-65+1] = 'X';
	 }
	 // FOR ADMIRAL
	 for (int i = 0; i < 1; i++) {
	 	char inp1, inp2;
	 	printf("Hazinenizi yerleştiriniz: (örn: A5) ");
	 	scanf("%c%c", &inp1, &inp2);
	 	field[inp2-48][inp1-65+1] = 'W';
	 }
	for (int i = 0; i < 11; i++) {
		for (int j = 0; j < 11; j++)
			printf("%c ", field[i][j]);
		printf("\n");
	} 
}
