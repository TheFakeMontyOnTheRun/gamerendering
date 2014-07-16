/**
 *
 */
package br.odb.gamerendering.rendering;

import br.odb.utils.Rect;

/**
 * @author monty
 *
 */
public class BorderedSquareRenderingNode extends RenderingNode {

    RenderingNode border[] = new RenderingNode[4];
    RenderingNode joints[] = new RenderingNode[4];
    RenderingNode content;
    private PatternRenderingNode background;

    public BorderedSquareRenderingNode(RenderingNode borders[],
            RenderingNode joints[], RenderingNode background,
            RenderingNode content, Rect rect, String id) {

        super("BorderedSquareRenderingNode_" + id);

        this.bounds = rect;

        Rect[] borderRects = new Rect[4];

        // cima
        borderRects[0] = new Rect();
        borderRects[0].x0 = joints[0].getWidth();
        borderRects[0].y0 = 0;
        borderRects[0].x1 = bounds.x1 - joints[1].getWidth();
        borderRects[0].y1 = borders[0].getHeight();

        // direita
        borderRects[1] = new Rect();
        borderRects[1].x0 = bounds.x1 - borders[1].getWidth();
        borderRects[1].y0 = joints[1].getHeight();
        borderRects[1].x1 = bounds.x1;
        borderRects[1].y1 = bounds.y1 - joints[2].getHeight();

        // baixo
        borderRects[2] = new Rect();
        borderRects[2].x0 = joints[3].getWidth();
        borderRects[2].y0 = bounds.y1 - borders[2].getHeight();
        borderRects[2].x1 = bounds.x1 - joints[2].getWidth();
        borderRects[2].y1 = bounds.y1;

        // esquerda
        borderRects[3] = new Rect();
        borderRects[3].x0 = 0;
        borderRects[3].y0 = joints[0].getHeight();
        borderRects[3].x1 = borders[3].getWidth();
        borderRects[3].y1 = bounds.y1 - joints[3].getHeight();

        for (int c = 0; c < 4; ++c) {

            this.border[c] = new PatternRenderingNode(borders[c],
                    borderRects[c]);
            this.joints[c] = joints[c];
        }
        this.background = new PatternRenderingNode(background, new Rect(
                joints[0].getWidth(), joints[0].getHeight(), bounds.x1
                - joints[2].getWidth() - joints[0].getWidth(),
                bounds.y1 - joints[2].getHeight() - joints[0].getHeight()));
        this.content = new PatternRenderingNode(content, new Rect(
                borders[3].getWidth(), borders[0].getHeight(), bounds.x1
                - borders[1].getWidth() - borders[3].getWidth(),
                bounds.y1 - borders[2].getHeight() - borders[0].getHeight()));

        float dx;
        float dy;

        dx = joints[1].bounds.getDX();
        dy = joints[1].bounds.getDY();
        joints[1].bounds.x0 = bounds.x1 - joints[1].getWidth();
        joints[1].bounds.setD(dx, dy);

        dx = joints[1].bounds.getDX();
        dy = joints[1].bounds.getDY();
        joints[2].bounds.x0 = bounds.x1 - joints[2].getWidth();
        joints[2].bounds.y0 = bounds.y1 - joints[2].getHeight();
        joints[2].bounds.setD(dx, dy);

        dx = joints[1].bounds.getDX();
        dy = joints[1].bounds.getDY();
        joints[3].bounds.y0 = bounds.y1 - joints[3].getHeight();
        joints[3].bounds.setD(dx, dy);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * br.odb.gamelib.rendering.RenderingNode#render(br.odb.gamelib.rendering
     * .RenderingContext)
     */
    @Override
    public void render(RenderingContext rc) {

        for (int c = 0; c < 4; ++c) {
            joints[c].render(rc);
        }

        background.render(rc);
        content.render(rc);

        for (int c = 0; c < 4; ++c) {
            border[c].render(rc);
        }
    }
}
