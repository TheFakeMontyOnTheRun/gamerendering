/**
 *
 */
package br.odb.gamerendering.rendering;

import br.odb.utils.Color;
import br.odb.utils.Rect;

/**
 * @author monty
 *
 */
public class SolidSquareRenderingNode extends RenderingNode {

    private Color color;

    /**
     * @param rect
     *
     */
    public SolidSquareRenderingNode( Rect rect,
            Color color) {

        super("square_" + rect.x0 + "_" + rect.y0 + "_" + rect.x1 + "_" + rect.y1 + "_" + color.getHTMLColor());
        this.bounds = rect;
        this.color = color;
    }

    @Override
    public void render(RenderingContext context) {
        context.fillRect(color, bounds);
    }
}
