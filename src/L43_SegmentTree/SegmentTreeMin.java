package L43_SegmentTree;

public class SegmentTreeMin implements SegmentTreeI{

	@Override
	public int operation(int v1, int v2) {
		return Math.min(v1, v2) ;
	}

	@Override
	public int defaultValue() {
		return Integer.MAX_VALUE ;
	}

}
