package br.odb.gamerendering.rendering;

import br.odb.utils.Rect;

public class PatternRenderingNode extends RenderingNode {

	private RenderingNode repeated;

	public PatternRenderingNode(RenderingNode node, Rect rect) {
		super( "PatternRenderingNode_" + node.getId() );

		this.repeated = node;
		this.bounds = rect;
	}

	@Override
	public void render(RenderingContext rc) {

		Rect dst = new Rect();
		int width = (int) repeated.bounds.getDX();
		int height = (int) repeated.bounds.getDY();

		rc.saveClipRect();
		rc.setClipRect(bounds);

		for (int x = (int) bounds.x0; x <= bounds.x1; x += width) {
			for (int y = (int) bounds.y0; y <= bounds.y1; y += height) {

				dst.set(x, y, width, height);
				repeated.bounds.set(dst);
				repeated.render(rc);
			}
		}

		rc.restoreClipRect();
	}
}
