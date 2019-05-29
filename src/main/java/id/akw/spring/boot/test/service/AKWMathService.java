package id.akw.spring.boot.test.service;

import org.springframework.stereotype.Service;

/**
 * @author adhityo.kresno (AKW)
 *
 */
@Service
public class AKWMathService implements IAKWMathService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * id.akw.spring.boot.test.service.IAKWMathService#powerSlow(java.lang.Integer,
	 * java.lang.Integer)
	 */
	@Override
	public Double powerSlow(Integer a, Integer b) {
		if (b == 0) {
			// aAlways return 1
			return 1d;
		} else if (b == 1) {
			// aReturn itself
			return (double) a;
		} else if (b == -1) {
			// aYou know why it is
			return (double) (1 / a);
		} else if (b > 1) {
			// aCall itself multiple itself
			return powerSlow(a, b - 1) * a;
		} else if (b < -1) {
			// aSame logic
			return powerSlow(a, b + 1) * ((double) (1 / a));
		} else {
			// aIs it possible to call this part?
			throw new IllegalArgumentException("Unhandled condition: " + b);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * id.akw.spring.boot.test.service.IAKWMathService#powerFast(java.lang.Integer,
	 * java.lang.Integer)
	 */
	@Override
	public Double powerFast(Integer a, Integer b) {
		if (b == 0) {
			return 1d;
		} else if (b == 1) {
			return (double) a;
		} else if (b == -1) {
			return (double) (1 / a);
		} else if (b > 1) {
			if (b % 2 == 1) {
				// aEven
				int half = (b - 1) / 2;

				return powerFast(a, half) * powerFast(a, half) * a;
			} else {
				// aOdd
				int half = b / 2;

				return powerFast(a, half) * powerFast(a, half);
			}
		} else if (b < -1) {
			if (b % 2 == 1) {
				// aEven
				int half = (b - 1) / 2;

				return powerFast(a, half) * powerFast(a, half) * ((double) (1 / a));
			} else {
				// aOdd
				int half = b / 2;

				return powerFast(a, half) * powerFast(a, half);
			}
		} else {
			// aIs it possible to call this part?
			throw new IllegalArgumentException("Unhandled condition: " + b);
		}
	}

}
