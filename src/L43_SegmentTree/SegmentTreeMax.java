package L43_SegmentTree;

public class SegmentTreeMax implements SegmentTreeI{

	@Override
	public int operation(int v1, int v2) {
		return Math.max(v1, v2) ;
	}

	@Override
	public int defaultValue() {
		return Integer.MIN_VALUE ;
	}

}
