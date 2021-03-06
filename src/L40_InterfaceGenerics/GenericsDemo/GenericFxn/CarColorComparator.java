package L40_InterfaceGenerics.GenericsDemo.GenericFxn;

import java.util.Comparator;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 */

public class CarColorComparator implements Comparator<Car> {

	@Override
	public int compare(Car tcar, Car ocar) {
		return tcar.color.compareTo(ocar.color);
	}

}