/**
 * Name: Katherine Ling
 * Date: November 29, 2019
 * Project Name: Rectangle
 * Description: the class contains:
 * 
 * - a Rectangle constructor
 *   reads in the left, bottom corner, and the rectangle's height and width. 
 *   If the height or width is a negative integer, then it will replace it 
 *   with 0)
 * 
 * - accessor and mutator methods 
 *   These methods are used to get or set a field variable. It gives the user 
 *   access to these private field variables outside of the class.
 * 
 * - toString
 *   print out the field variables associated with the rectangle object (left,
 *   bottom, width and height)
 * 
 * - area
 *   calculates and returns the area of the rectangle
 * 
 * - perimeter
 *   calculates and returns the area of the perimeter
 * 
 * - intersection (further explained in the description of intersection)
 *   method returns the rectangle formed by the two rectangle parameters
 * 
 * - total perimeter
 *   the method calculates and returns the total perimeter of the figure formed 
 *   by the two rectangles
 * 
 * - contains 
 *   method returns true if the rectangle passed through the explicit parameter
 *   is within the rectangle passed by the implicit parameter. Else, return 
 *   false
 * 
 **/
package Culminating_Assignment;

public class Rectangle {
    //========================================
    // Field Variables
    //========================================
    private int left;   // x-coordinate of the left, bottom corner 
    private int bottom; // y-coordinate of the left, bottom corner
    private int width;  // width of the rectangle
    private int height; // height of the rectangle
    
    /**
     * Description: Rectangle constructor, negatives width and height values 
     * should be changed to 0
     * Pre condition: params should be initialized (have some value)
     * Post condition:an instance of the object will be created in memory with 
     * the correct values 
     * @param left x-coordinate of the left, bottom corner 
     * @param bottom y-coordinate of the left, bottom corner
     * @param width width of the rectangle
     * @param height height of the rectangle
     **/
    public Rectangle(int left, int bottom, int width, int height) {
        this.left = left;
        this.bottom = bottom;
        
        // negative width will be replaced with 0
        if (width < 0) 
            this.width = 0;
        else
            this.width = width;

        // negative height will be replaced with 0
        if (height < 0) 
            this.height = 0;
        else
            this.height = height;
    }

    /**
     * Description: Another Rectangle constructor, allows user to use setter 
     * methods to initialize the field variables
     * Pre condition: none
     * Post condition: an instance of the object will be created in memory; or
     * initialized to 0
     * 
     **/
    public Rectangle() {
        this.left = 0;
        this.bottom = 0;
        this.width = 0;
        this.height = 0;
    }
    
    /**
     * ========================================================================
     * Accessor Methods
     * Description: allows the user to retrieve the value of a private field
     * variable - getBottom will return the variable bottom
     * Post condition: return what is specified in the method name 
     * (getLeft -> return left)
     * @return left - x coordinate of the rectangle's left, bottom corner
     * @return bottom - y coordinate of the rectangle's right, bottom corner
     * @return width - the width of the rectangle
     * @return bottom - the height of the rectangle 
     * ========================================================================
     **/
    
    public int getLeft() {
        return left;
    }
    
    public int getBottom() {
        return bottom;
    }
    
    public int getWidth() {
        return width;
    }    
    
    public int getHeight() {
        return height;
    }

    /**
     * ========================================================================
     * Mutator Methods
     * Description: allows the user to change the value of a private field 
     * variable
     * Pre-condition: parameters should be valid - width and height should be
     * greater or equal to 0
     * Post-condition: set the field variable to the parameter
     * @param left - x coordinate of the rectangle's left, bottom corner
     * @param bottom - y coordinate of the rectangle's right, bottom corner
     * @param width - the width of the rectangle
     * @param height - the height of the rectangle
     * ========================================================================
     **/
    
    public void setLeft(int left) {
        this.left = left;
    }
    
    public void setBottom(int bottom) {
        this.bottom = bottom;
    }
    
    public void setWidth(int width) {
        // negative width will be replaced with 0
        if (width < 0) 
            this.width = 0;
        else
            this.width = width;
    }
    
    public void setHeight(int height) {
        // negative height will be replaced with 0
        if (height < 0) 
            this.height = 0;
        else
            this.height = height;        
    }

    /**
     * Description: print out the field variables associated with the object 
     * (left, bottom, width, and height)
     * Pre condition: parameters should be valid, width and height should be 
     * greater or equal to 0
     * Post condition: return the field variables
     * @return base: (left, bottom) w: width h: height (string contains all
     * the field variables associated with the object)
     **/
    public String toString() {
        return "base: (" + left + "," + bottom + ")  w:" + width + " h:" + 
                height;
    }
    
    /**
     * Description: calculates the area of the rectangle
     * Pre condition: width and height should be valid - positive integers or
     * zero
     * Post condition: return the area of the rectangle
     * @return area (width * height), the area of the rectangle
     **/    
    public int area() {
        return width * height;
    }

    /**
     * Description: calculates the perimeter of the rectangle
     * Pre condition: width and height should be valid - positive integers or 
     * zero
     * Post condition: return the perimeter of the rectangle
     * @return perimeter of the rectangle as defined by the assignment 
     * description
     **/    
    public int perimeter() {
        
        // check if the rectangle is a line, return the length of the line
        if (height == 0 || width == 0) 
            return height + width;

        return 2 * (width + height);
    }

    /**
     * Description: the static method returns the rectangle formed by the area 
     * common to the two rectangles. If they do not intersect, the method will 
     * return a rectangle where all fields are zero. If the rectangles only 
     * touch then the width or height will be set to zero, but all other 
     * parameters will be properly calculated and stored. The code assumes that
     * r1 is always the left-most, bottom corner. It will swap the location of 
     * r1 and r2 accordingly to follow this assumption.
     * Pre condition: the params should be initialized or declared before this 
     * method is called, width and height should be greater or equal to 0 - 
     * should be valid rectangles
     * Post condition: return the overlapped rectangle object
     * @param r1 first rectangle object
     * @param r2 second rectangle object
     * @return rectangle formed by the overlap of r1 and r2
     **/    
    public static Rectangle intersection(Rectangle r1, Rectangle r2) {
        // assume r1 is the left-most rectangle. Otherwise, swap r1 with r2.
        if (r1.left > r2.left) { 
            Rectangle temp = r2;
            r2 = r1;
            r1 = temp;
        }
        // find the intersection in the x-axis
        // the intersected line has a point and length.
        int pointX = getPointIntersectedLine(r1.left, r1.width, 
                r2.left, r2.width);
        int lengthX = getLengthIntersectedLine(r1.left, r1.width, 
                r2.left, r2.width);

        // assume r1 is the lowest rectangle. Otherwise, swap r1 with r2.
        if (r1.bottom > r2.bottom) {
            Rectangle temp = r2;
            r2 = r1;
            r1 = temp;
        }
        
        // find the intersection in the y-axis
        // the intersected line has a point and length.
        int pointY = getPointIntersectedLine(r1.bottom, r1.height, 
                r2.bottom, r2.height);
        int lengthY = getLengthIntersectedLine(r1.bottom, r1.height, 
                r2.bottom, r2.height);

        // check if the length is negative (meaning that the rectangles do not 
        // overlap). If so, return an empty rectangle object.
        if (lengthX < 0 || lengthY < 0)
            return new Rectangle();
        
        return new Rectangle(pointX, pointY, lengthX, lengthY);
    }

    /**
     * An illustration to the intersected line methods.
     * 
     * case 1: two lines do not overlap
     * 
     *       P1        P1+L1  
     *  ------=============------------------------------------------
     *  ---------------------------======================-----------
     *                             P2                  P2+L2
     * 
     * case 2: two lines overlapped
     * 
     *       P1        P1+L1  
     *  ------=====+++++++------------------------------------------
     *  -----------+++++++===============-----------
     *             P2                  P2+L2
     * 
     * case 3: two lines overlapped (contained)
     *
     *       P1                   P1+L1  
     *  ------=====++++++++++========-------------------------------
     *  -----------++++++++++---------------------------------------
     *             P2     P2+L2
     * 
     **/
    
    /**
     * Description: the static method will find the "point" of the intersected 
     * line
     * Pre condition: point1 < point2; length1 and length2 are positive integers
     * Post condition: return the point of the intersected line
     * @param point1 the coordinate point of line 1
     * @param length1 the length of line 1
     * @param point2 the coordinate point of line 2
     * @param length2 the length of line 2
     * @return the point of the intersected line
     **/        
    private static int getPointIntersectedLine(int point1, int length1, 
            int point2, int length2) {
        // checks if point1 and point2 touch?
        if ((point1 + length1) < point2)
            return 0;
        
        return point2;
    }

    /**
     * Description: the static method will find the "length" of the intersected 
     * line
     * Pre condition: point1 < point2; length1 and length2 are positive integers
     * Post condition: return the length of the intersected line
     * @param point1 the coordinate point of line 1
     * @param length1 the length of line 1
     * @param point2 the coordinate point of line 2
     * @param length2 the length of line 2
     * @return the length of the intersected line
     **/       
    private static int getLengthIntersectedLine(int point1, int length1, 
            int point2, int length2) {
        
        // checks if line2 is contained in line1?
        if ((point1 + length1) > (point2 + length2))
            return length2;
        
        return point1 + length1 - point2;
    }
 
    /**
     * Description: the static method calculates and returns the total perimeter 
     * of the figure formed by the two rectangles
     * Pre condition: the parameters should be initialized/ declared before this 
     * method is called, width and height should be (valid) greater or
     * equal to 0
     * Post condition: return the perimeter of the overlapped rectangle
     * @param r1 first rectangle object
     * @param r2 second rectangle object
     * @return r1.perimeter() + r2.perimeter()  -- if the two rectangles do not 
     * overlap or touch
     * @return formedRectangle.height + formedRectangle.width -- if the two 
     * rectangles touch, return the length of the line
     * @return formedRectangle.perimeter() -- if the two rectangles overlap
     **/        
    public static int totalPerimeter(Rectangle r1, Rectangle r2) {
        // find the new overlapped rectangle
        Rectangle formedRectangle = Rectangle.intersection(r1, r2); 
        
        return r1.perimeter() + r2.perimeter() - formedRectangle.perimeter();
    }

    /**
     * Description: the instance method will compare the area of r2 and the 
     * overlapped rectangle. It will return true if the rectangle passed through
     * the explicit parameter is within the implicit parameter (the area of the 
     * overlapped rectangle will be equal to the area of r2. It will return 
     * false otherwise.
     * Pre condition: the params should be initialized or declared before this 
     * method is called, width and height should be greater or equal to 0
     * Post condition: return a boolean value depending if the rectangle passed 
     * by the explicit parameter is contained within the rectangle passed by the
     * implicit parameter.
     * @param r2 second rectangle object
     * @return boolean value (true or false) -- true/false depending on if 
     * r2.area == r.area (if r2 is contained in r1)
     **/            
    public boolean contains(Rectangle r2) {
        // find the overlapped rectangle 
        Rectangle r = Rectangle.intersection(this, r2); 
        
        // compare the area of the overlapped rectangle and r2's area
        if (r.area() == r2.area()) 
            return true;
        return false;
    }
}
