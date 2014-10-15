public class FactoryWithoutIfElse {
	
	public static void main(String[] args) {
		System.out.println(ValidatorType.Integer.create());
	}

}

enum ValidatorType {
	Integer {
		public Object create() {
			return Integer;
		}
	},

	Float {
		public Object create() {
			return Float;
		}
	},

	Long {
		public Object create() {
			return Long;
		}
	},

	String {
		public Object create() {
			return String;
		}
	},

	Char {
		public Object create() {
			return Char;
		}
	};

	public Object create() {
		return null;
	}
}