package model;

public class Sintoma_mental extends Sintoma{

		private Enum<?> humor;
		private Enum<?> sentimentos;
		
		
		public Enum<?> getHumor() {
			return humor;
		}
		public void setHumor(Enum<?> humor) {
			this.humor = humor;
		}
		public Enum<?> getSentimentos() {
			return sentimentos;
		}
		public void setSentimentos(Enum<?> sentimentos) {
			this.sentimentos = sentimentos;
		}
		
}
