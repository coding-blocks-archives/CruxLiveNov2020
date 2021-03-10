package L43_SegmentTree;

public class SegmentTreeProduct implements SegmentTreeI{

	@Override
	public int operation(int v1, int v2) {
		return v1 * v2 ;
	}

	@Override
	public int defaultValue() {
		return 1;
	}

}
