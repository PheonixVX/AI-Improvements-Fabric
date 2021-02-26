package io.github.pheonixvx.aiimprovementsfabric.modifier.filters;

/**
 * Created by Dark(DarkGuardsman, Robert) on 8/3/2019. Ported to Fabric on 2/24/2021 by PheonixVX.
 */
public enum FilterResult
{
	/** Nothing happened, continue to next call */
	DID_NOTHING,
	/** Passed the entity down a layer, should not continue to next call */
	FILTERED,
	/** Changed the Entity but should still continue to pass through */
	MODIFIED
}
