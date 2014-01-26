//============================================================================
//  Acquisition functions
//============================================================================
//IMAQ_FUNC Image* IMAQ_STDCALL imaqCopyFromRing(SESSION_ID sessionID, Image* image, int imageToCopy, int* imageNumber, Rect rect);
//IMAQ_FUNC Image* IMAQ_STDCALL imaqEasyAcquire(const char* interfaceName);
//IMAQ_FUNC Image* IMAQ_STDCALL imaqExtractFromRing(SESSION_ID sessionID, int imageToExtract, int* imageNumber);
//IMAQ_FUNC Image* IMAQ_STDCALL imaqGrab(SESSION_ID sessionID, Image* image, int immediate);
//IMAQ_FUNC int    IMAQ_STDCALL imaqReleaseImage(SESSION_ID sessionID);
//IMAQ_FUNC int    IMAQ_STDCALL imaqSetupGrab(SESSION_ID sessionID, Rect rect);
//IMAQ_FUNC int    IMAQ_STDCALL imaqSetupRing(SESSION_ID sessionID, Image** images, int numImages, int skipCount, Rect rect);
//IMAQ_FUNC int    IMAQ_STDCALL imaqSetupSequence(SESSION_ID sessionID, Image** images, int numImages, int skipCount, Rect rect);
//IMAQ_FUNC Image* IMAQ_STDCALL imaqSnap(SESSION_ID sessionID, Image* image, Rect rect);
//IMAQ_FUNC int    IMAQ_STDCALL imaqStartAcquisition(SESSION_ID sessionID);
//IMAQ_FUNC int    IMAQ_STDCALL imaqStopAcquisition(SESSION_ID sessionID);

//============================================================================
//  Arithmetic functions
//============================================================================
IMAQ_FUNC int IMAQ_STDCALL imaqAbsoluteDifference(Image* dest, const Image* sourceA, const Image* sourceB);
IMAQ_FUNC int IMAQ_STDCALL imaqAbsoluteDifferenceConstant(Image* dest, const Image* source, PixelValue value);
IMAQ_FUNC int IMAQ_STDCALL imaqAdd(Image* dest, const Image* sourceA, const Image* sourceB);
IMAQ_FUNC int IMAQ_STDCALL imaqAddConstant(Image* dest, const Image* source, PixelValue value);
IMAQ_FUNC int IMAQ_STDCALL imaqAverage(Image* dest, const Image* sourceA, const Image* sourceB);
IMAQ_FUNC int IMAQ_STDCALL imaqAverageConstant(Image* dest, const Image* source, PixelValue value);
IMAQ_FUNC int IMAQ_STDCALL imaqDivide2(Image* dest, const Image* sourceA, const Image* sourceB, RoundingMode roundingMode);
IMAQ_FUNC int IMAQ_STDCALL imaqDivideConstant2(Image* dest, const Image* source, PixelValue value, RoundingMode roundingMode);
IMAQ_FUNC int IMAQ_STDCALL imaqMax(Image* dest, const Image* sourceA, const Image* sourceB);
IMAQ_FUNC int IMAQ_STDCALL imaqMaxConstant(Image* dest, const Image* source, PixelValue value);
IMAQ_FUNC int IMAQ_STDCALL imaqMin(Image* dest, const Image* sourceA, const Image* sourceB);
IMAQ_FUNC int IMAQ_STDCALL imaqMinConstant(Image* dest, const Image* source, PixelValue value);
IMAQ_FUNC int IMAQ_STDCALL imaqModulo(Image* dest, const Image* sourceA, const Image* sourceB);
IMAQ_FUNC int IMAQ_STDCALL imaqModuloConstant(Image* dest, const Image* source, PixelValue value);
IMAQ_FUNC int IMAQ_STDCALL imaqMulDiv(Image* dest, const Image* sourceA, const Image* sourceB, float value);
IMAQ_FUNC int IMAQ_STDCALL imaqMultiply(Image* dest, const Image* sourceA, const Image* sourceB);
IMAQ_FUNC int IMAQ_STDCALL imaqMultiplyConstant(Image* dest, const Image* source, PixelValue value);
IMAQ_FUNC int IMAQ_STDCALL imaqSubtract(Image* dest, const Image* sourceA, const Image* sourceB);
IMAQ_FUNC int IMAQ_STDCALL imaqSubtractConstant(Image* dest, const Image* source, PixelValue value);

//============================================================================
//  Spatial Filters functions
//============================================================================
//IMAQ_FUNC int IMAQ_STDCALL imaqCannyEdgeFilter(Image* dest, const Image* source, const CannyOptions* options);
//IMAQ_FUNC int IMAQ_STDCALL imaqConvolve2(Image* dest, Image* source, float* kernel, int matrixRows, int matrixCols, float normalize, Image* mask, RoundingMode roundingMode);
//IMAQ_FUNC int IMAQ_STDCALL imaqCorrelate(Image* dest, Image* source, const Image* templateImage, Rect rect);
//IMAQ_FUNC int IMAQ_STDCALL imaqEdgeFilter(Image* dest, Image* source, OutlineMethod method, const Image* mask);
//IMAQ_FUNC int IMAQ_STDCALL imaqLowPass(Image* dest, Image* source, int width, int height, float tolerance, const Image* mask);
//IMAQ_FUNC int IMAQ_STDCALL imaqMedianFilter(Image* dest, Image* source, int width, int height, const Image* mask);
//IMAQ_FUNC int IMAQ_STDCALL imaqNthOrderFilter(Image* dest, Image* source, int width, int height, int n, const Image* mask);

//============================================================================
//  Drawing functions
//============================================================================
//IMAQ_FUNC int IMAQ_STDCALL imaqDrawLineOnImage(Image* dest, const Image* source, DrawMode mode, Point start, Point end, float newPixelValue);
//IMAQ_FUNC int IMAQ_STDCALL imaqDrawShapeOnImage(Image* dest, const Image* source, Rect rect, DrawMode mode, ShapeMode shape, float newPixelValue);
//IMAQ_FUNC int IMAQ_STDCALL imaqDrawTextOnImage(Image* dest, const Image* source, Point coord, const char* text, const DrawTextOptions* options, int* fontNameUsed);

//============================================================================
//  Interlacing functions
//============================================================================
//IMAQ_FUNC int IMAQ_STDCALL imaqInterlaceCombine(Image* frame, const Image* odd, const Image* even);
//IMAQ_FUNC int IMAQ_STDCALL imaqInterlaceSeparate(const Image* frame, Image* odd, Image* even);

//============================================================================
//  Image Information functions
//============================================================================
//IMAQ_FUNC char** IMAQ_STDCALL imaqEnumerateCustomKeys(const Image* image, unsigned int* size);
//IMAQ_FUNC int    IMAQ_STDCALL imaqGetBitDepth(const Image* image, unsigned int* bitDepth);
//IMAQ_FUNC int    IMAQ_STDCALL imaqGetBytesPerPixel(const Image* image, int* byteCount);
//IMAQ_FUNC int    IMAQ_STDCALL imaqGetImageInfo(const Image* image, ImageInfo* info);
//IMAQ_FUNC int    IMAQ_STDCALL imaqGetImageType(const Image* image, ImageType* type);
//IMAQ_FUNC int    IMAQ_STDCALL imaqGetMaskOffset(const Image* image, Point* offset);
//IMAQ_FUNC void*  IMAQ_STDCALL imaqGetPixelAddress(const Image* image, Point pixel);
//IMAQ_FUNC int    IMAQ_STDCALL imaqGetVisionInfoTypes(const Image* image, unsigned int* present);
//IMAQ_FUNC int    IMAQ_STDCALL imaqIsImageEmpty(const Image* image, int* empty);
//IMAQ_FUNC void*  IMAQ_STDCALL imaqReadCustomData(const Image* image, const char* key, unsigned int* size);
//IMAQ_FUNC int    IMAQ_STDCALL imaqRemoveCustomData(Image* image, const char* key);
//IMAQ_FUNC int    IMAQ_STDCALL imaqRemoveVisionInfo2(const Image* image, unsigned int info);
//IMAQ_FUNC int    IMAQ_STDCALL imaqSetBitDepth(Image* image, unsigned int bitDepth);
//IMAQ_FUNC int    IMAQ_STDCALL imaqSetImageSize(Image* image, int width, int height);
//IMAQ_FUNC int    IMAQ_STDCALL imaqSetMaskOffset(Image* image, Point offset);
//IMAQ_FUNC int    IMAQ_STDCALL imaqWriteCustomData(Image* image, const char* key, const void* data, unsigned int size);
//============================================================================
//  Morphology functions
//============================================================================
//IMAQ_FUNC int           IMAQ_STDCALL imaqConvexHull(Image* dest, Image* source, int connectivity8);
//IMAQ_FUNC int           IMAQ_STDCALL imaqDanielssonDistance(Image* dest, Image* source);
//IMAQ_FUNC int           IMAQ_STDCALL imaqFillHoles(Image* dest, const Image* source, int connectivity8);
//IMAQ_FUNC CircleReport* IMAQ_STDCALL imaqFindCircles(Image* dest, Image* source, float minRadius, float maxRadius, int* numCircles);
//IMAQ_FUNC int           IMAQ_STDCALL imaqLabel2(Image* dest, Image* source, int connectivity8, int* particleCount);
//IMAQ_FUNC int           IMAQ_STDCALL imaqMorphology(Image* dest, Image* source, MorphologyMethod method, const StructuringElement* structuringElement);
//IMAQ_FUNC int           IMAQ_STDCALL imaqRejectBorder(Image* dest, Image* source, int connectivity8);
//IMAQ_FUNC int           IMAQ_STDCALL imaqSegmentation(Image* dest, Image* source);
//IMAQ_FUNC int           IMAQ_STDCALL imaqSeparation(Image* dest, Image* source, int erosions, const StructuringElement* structuringElement);
//IMAQ_FUNC int           IMAQ_STDCALL imaqSimpleDistance(Image* dest, Image* source, const StructuringElement* structuringElement);
//IMAQ_FUNC int           IMAQ_STDCALL imaqSizeFilter(Image* dest, Image* source, int connectivity8, int erosions, SizeType keepSize, const StructuringElement* structuringElement);
//IMAQ_FUNC int           IMAQ_STDCALL imaqSkeleton(Image* dest, Image* source, SkeletonMethod method);
//============================================================================
//  Logical functions
//============================================================================
//IMAQ_FUNC int IMAQ_STDCALL imaqAnd(Image* dest, const Image* sourceA, const Image* sourceB);
//IMAQ_FUNC int IMAQ_STDCALL imaqAndConstant(Image* dest, const Image* source, PixelValue value);
//IMAQ_FUNC int IMAQ_STDCALL imaqCompare(Image* dest, const Image* source, const Image* compareImage, ComparisonFunction compare);
//IMAQ_FUNC int IMAQ_STDCALL imaqCompareConstant(Image* dest, const Image* source, PixelValue value, ComparisonFunction compare);
//IMAQ_FUNC int IMAQ_STDCALL imaqLogicalDifference(Image* dest, const Image* sourceA, const Image* sourceB);
//IMAQ_FUNC int IMAQ_STDCALL imaqLogicalDifferenceConstant(Image* dest, const Image* source, PixelValue value);
//IMAQ_FUNC int IMAQ_STDCALL imaqNand(Image* dest, const Image* sourceA, const Image* sourceB);
//IMAQ_FUNC int IMAQ_STDCALL imaqNandConstant(Image* dest, const Image* source, PixelValue value);
//IMAQ_FUNC int IMAQ_STDCALL imaqNor(Image* dest, const Image* sourceA, const Image* sourceB);
//IMAQ_FUNC int IMAQ_STDCALL imaqNorConstant(Image* dest, const Image* source, PixelValue value);
//IMAQ_FUNC int IMAQ_STDCALL imaqOr(Image* dest, const Image* sourceA, const Image* sourceB);
//IMAQ_FUNC int IMAQ_STDCALL imaqOrConstant(Image* dest, const Image* source, PixelValue value);
//IMAQ_FUNC int IMAQ_STDCALL imaqXnor(Image* dest, const Image* sourceA, const Image* sourceB);
//IMAQ_FUNC int IMAQ_STDCALL imaqXnorConstant(Image* dest, const Image* source, PixelValue value);
//IMAQ_FUNC int IMAQ_STDCALL imaqXor(Image* dest, const Image* sourceA, const Image* sourceB);
//IMAQ_FUNC int IMAQ_STDCALL imaqXorConstant(Image* dest, const Image* source, PixelValue value);

//============================================================================
//  Particle Analysis functions
//============================================================================


//============================================================================
//  Analytic Geometry functions
//============================================================================
// IMAQ_FUNC int           IMAQ_STDCALL imaqBuildCoordinateSystem(const Point* points, ReferenceMode mode, AxisOrientation orientation, CoordinateSystem* system);
// IMAQ_FUNC BestCircle2*  IMAQ_STDCALL imaqFitCircle2(const PointFloat* points, int numPoints, const FitCircleOptions* options);
// IMAQ_FUNC BestEllipse2* IMAQ_STDCALL imaqFitEllipse2(const PointFloat* points, int numPoints, const FitEllipseOptions* options);
// IMAQ_FUNC BestLine*     IMAQ_STDCALL imaqFitLine(const PointFloat* points, int numPoints, const FitLineOptions* options);
// IMAQ_FUNC int           IMAQ_STDCALL imaqGetAngle(PointFloat start1, PointFloat end1, PointFloat start2, PointFloat end2, float* angle);
// IMAQ_FUNC int           IMAQ_STDCALL imaqGetBisectingLine(PointFloat start1, PointFloat end1, PointFloat start2, PointFloat end2, PointFloat* bisectStart, PointFloat* bisectEnd);
// IMAQ_FUNC int           IMAQ_STDCALL imaqGetDistance(PointFloat point1, PointFloat point2, float* distance);
// IMAQ_FUNC int           IMAQ_STDCALL imaqGetIntersection(PointFloat start1, PointFloat end1, PointFloat start2, PointFloat end2, PointFloat* intersection);
// IMAQ_FUNC int           IMAQ_STDCALL imaqGetMidLine(PointFloat refLineStart, PointFloat refLineEnd, PointFloat point, PointFloat* midLineStart, PointFloat* midLineEnd);
// IMAQ_FUNC int           IMAQ_STDCALL imaqGetPerpendicularLine(PointFloat refLineStart, PointFloat refLineEnd, PointFloat point, PointFloat* perpLineStart, PointFloat* perpLineEnd, double* distance);
// IMAQ_FUNC SegmentInfo*  IMAQ_STDCALL imaqGetPointsOnContour(const Image* image, int* numSegments);
// IMAQ_FUNC Point*        IMAQ_STDCALL imaqGetPointsOnLine(Point start, Point end, int* numPoints);
// IMAQ_FUNC int           IMAQ_STDCALL imaqGetPolygonArea(const PointFloat* points, int numPoints, float* area);
// IMAQ_FUNC float*        IMAQ_STDCALL imaqInterpolatePoints(const Image* image, const Point* points, int numPoints, InterpolationMethod method, int subpixel, int* interpCount);

//============================================================================
//  Border functions
//============================================================================
//IMAQ_FUNC int IMAQ_STDCALL imaqFillBorder(Image* image, BorderMethod method);
//IMAQ_FUNC int IMAQ_STDCALL imaqGetBorderSize(const Image* image, int* borderSize);
//IMAQ_FUNC int IMAQ_STDCALL imaqSetBorderSize(Image* image, int size);

//============================================================================
//  Image Management functions
//============================================================================
//IMAQ_FUNC int    IMAQ_STDCALL imaqArrayToImage(Image* image, const void* array, int numCols, int numRows);
//IMAQ_FUNC void*  IMAQ_STDCALL imaqImageToArray(const Image* image, Rect rect, int* columns, int* rows);

//============================================================================
//  Color Processing functions
//============================================================================
//IMAQ_FUNC Color2                IMAQ_STDCALL imaqChangeColorSpace2(const Color2* sourceColor, ColorMode sourceSpace, ColorMode destSpace, double offset, const CIEXYZValue* whiteReference);
//IMAQ_FUNC int                   IMAQ_STDCALL imaqColorBCGTransform(Image* dest, const Image* source, const BCGOptions* redOptions, const BCGOptions* greenOptions, const BCGOptions* blueOptions, const Image* mask);
//IMAQ_FUNC ColorHistogramReport* IMAQ_STDCALL imaqColorHistogram2(Image* image, int numClasses, ColorMode mode, const CIEXYZValue* whiteReference, Image* mask);
//IMAQ_FUNC int                   IMAQ_STDCALL imaqColorLookup(Image* dest, const Image* source, ColorMode mode, const Image* mask, const short* plane1, const short* plane2, const short* plane3);

//============================================================================
//  Transform functions
//============================================================================
//IMAQ_FUNC int IMAQ_STDCALL imaqBCGTransform(Image* dest, const Image* source, const BCGOptions* options, const Image* mask);
//IMAQ_FUNC int IMAQ_STDCALL imaqEqualize(Image* dest, const Image* source, float min, float max, const Image* mask);
//IMAQ_FUNC int IMAQ_STDCALL imaqInverse(Image* dest, const Image* source, const Image* mask);
//IMAQ_FUNC int IMAQ_STDCALL imaqLookup(Image* dest, const Image* source, const short* table, const Image* mask);
//IMAQ_FUNC int IMAQ_STDCALL imaqMathTransform(Image* dest, const Image* source, MathTransformMethod method, float rangeMin, float rangeMax, float power, const Image* mask);
//IMAQ_FUNC int IMAQ_STDCALL imaqWatershedTransform(Image* dest, const Image* source, int connectivity8, int* zoneCount);


//============================================================================
//  Utilities functions
//============================================================================
//IMAQ_FUNC const float* IMAQ_STDCALL imaqGetKernel(KernelFamily family, int size, int number);
//IMAQ_FUNC Annulus      IMAQ_STDCALL imaqMakeAnnulus(Point center, int innerRadius, int outerRadius, double startAngle, double endAngle);
//IMAQ_FUNC Point        IMAQ_STDCALL imaqMakePoint(int xCoordinate, int yCoordinate);
//IMAQ_FUNC PointFloat   IMAQ_STDCALL imaqMakePointFloat(float xCoordinate, float yCoordinate);
//IMAQ_FUNC Rect         IMAQ_STDCALL imaqMakeRect(int top, int left, int height, int width);
//IMAQ_FUNC Rect         IMAQ_STDCALL imaqMakeRectFromRotatedRect(RotatedRect rotatedRect);
//IMAQ_FUNC RotatedRect  IMAQ_STDCALL imaqMakeRotatedRect(int top, int left, int height, int width, double angle);
//IMAQ_FUNC RotatedRect  IMAQ_STDCALL imaqMakeRotatedRectFromRect(Rect rect);
//IMAQ_FUNC int          IMAQ_STDCALL imaqMulticoreOptions(MulticoreOperation operation, unsigned int* customNumCores);

//============================================================================
//  Image Manipulation functions
//============================================================================
//IMAQ_FUNC int   IMAQ_STDCALL imaqCast(Image* dest, const Image* source, ImageType type, const float* lookup, int shift);
//IMAQ_FUNC int   IMAQ_STDCALL imaqCopyRect(Image* dest, const Image* source, Rect rect, Point destLoc);
//IMAQ_FUNC int   IMAQ_STDCALL imaqDuplicate(Image* dest, const Image* source);
//IMAQ_FUNC void* IMAQ_STDCALL imaqFlatten(const Image* image, FlattenType type, CompressionType compression, int quality, unsigned int* size);
//IMAQ_FUNC int   IMAQ_STDCALL imaqFlip(Image* dest, const Image* source, FlipAxis axis);
//IMAQ_FUNC int   IMAQ_STDCALL imaqMask(Image* dest, const Image* source, const Image* mask);
//IMAQ_FUNC int   IMAQ_STDCALL imaqResample(Image* dest, const Image* source, int newWidth, int newHeight, InterpolationMethod method, Rect rect);
//IMAQ_FUNC int   IMAQ_STDCALL imaqRotate2(Image* dest, const Image* source, float angle, PixelValue fill, InterpolationMethod method, int maintainSize);
//IMAQ_FUNC int   IMAQ_STDCALL imaqScale(Image* dest, const Image* source, int xScale, int yScale, ScalingMode scaleMode, Rect rect);
//IMAQ_FUNC int   IMAQ_STDCALL imaqShift(Image* dest, const Image* source, int shiftX, int shiftY, PixelValue fill);
//IMAQ_FUNC int   IMAQ_STDCALL imaqTranspose(Image* dest, const Image* source);
//IMAQ_FUNC int   IMAQ_STDCALL imaqUnflatten(Image* image, const void* data, unsigned int size);
//IMAQ_FUNC int   IMAQ_STDCALL imaqUnwrapImage(Image* dest, const Image* source, Annulus annulus, RectOrientation orientation, InterpolationMethod method);
//IMAQ_FUNC int   IMAQ_STDCALL imaqView3D(Image* dest, Image* source, const View3DOptions* options);

//============================================================================
//  Pattern Matching functions
//============================================================================
//IMAQ_FUNC CircleMatch*              IMAQ_STDCALL imaqDetectCircles(const Image* image, const CircleDescriptor* circleDescriptor, const CurveOptions* curveOptions, const ShapeDetectionOptions* shapeDetectionOptions, const ROI* roi, int* numMatchesReturned);
//IMAQ_FUNC LineMatch*                IMAQ_STDCALL imaqDetectLines(const Image* image, const LineDescriptor* lineDescriptor, const CurveOptions* curveOptions, const ShapeDetectionOptions* shapeDetectionOptions, const ROI* roi, int* numMatchesReturned);
//IMAQ_FUNC RectangleMatch*           IMAQ_STDCALL imaqDetectRectangles(const Image* image, const RectangleDescriptor* rectangleDescriptor, const CurveOptions* curveOptions, const ShapeDetectionOptions* shapeDetectionOptions, const ROI* roi, int* numMatchesReturned);
//IMAQ_FUNC FeatureData*              IMAQ_STDCALL imaqGetGeometricFeaturesFromCurves(const Curve* curves, unsigned int numCurves, const FeatureType* featureTypes, unsigned int numFeatureTypes, unsigned int* numFeatures);
//IMAQ_FUNC FeatureData*              IMAQ_STDCALL imaqGetGeometricTemplateFeatureInfo(const Image* pattern, unsigned int* numFeatures);
//IMAQ_FUNC int                       IMAQ_STDCALL imaqLearnColorPattern(Image* image, const LearnColorPatternOptions* options);
//IMAQ_FUNC int                       IMAQ_STDCALL imaqLearnGeometricPattern(Image* image, PointFloat originOffset, const CurveOptions* curveOptions, const LearnGeometricPatternAdvancedOptions* advancedLearnOptions, const Image* mask);
//IMAQ_FUNC MultipleGeometricPattern* IMAQ_STDCALL imaqLearnMultipleGeometricPatterns(const Image** patterns, unsigned int numberOfPatterns, const String255* labels);
//IMAQ_FUNC int                       IMAQ_STDCALL imaqLearnPattern3(Image* image, LearningMode learningMode, LearnPatternAdvancedOptions* advancedOptions, const Image* mask);
//IMAQ_FUNC PatternMatch*             IMAQ_STDCALL imaqMatchColorPattern(const Image* image, Image* pattern, const MatchColorPatternOptions* options, Rect searchRect, int* numMatches);
//IMAQ_FUNC GeometricPatternMatch2*   IMAQ_STDCALL imaqMatchGeometricPattern2(const Image* image, const Image* pattern, const CurveOptions* curveOptions, const MatchGeometricPatternOptions* matchOptions, const MatchGeometricPatternAdvancedOptions2* advancedMatchOptions, const ROI* roi, int* numMatches);
//IMAQ_FUNC GeometricPatternMatch2*   IMAQ_STDCALL imaqMatchMultipleGeometricPatterns(const Image* image, const MultipleGeometricPattern* multiplePattern, const ROI* roi, int* numMatches);
//IMAQ_FUNC PatternMatch*             IMAQ_STDCALL imaqMatchPattern2(const Image* image, const Image* pattern, const MatchPatternOptions* options, const MatchPatternOptions* advancedOptions, Rect searchRect, int* numMatches);
//IMAQ_FUNC MultipleGeometricPattern* IMAQ_STDCALL imaqReadMultipleGeometricPatternFile(const char* fileName, String255 description);
//IMAQ_FUNC PatternMatch*             IMAQ_STDCALL imaqRefineMatches(const Image* image, const Image* pattern, const PatternMatch* candidatesIn, int numCandidatesIn, MatchPatternOptions* options, MatchPatternAdvancedOptions* advancedOptions, int* numCandidatesOut);
//IMAQ_FUNC int                       IMAQ_STDCALL imaqSetMultipleGeometricPatternsOptions(MultipleGeometricPattern* multiplePattern, const char* label, const CurveOptions* curveOptions, const MatchGeometricPatternOptions* matchOptions, const MatchGeometricPatternAdvancedOptions2* advancedMatchOptions);
//IMAQ_FUNC int                       IMAQ_STDCALL imaqWriteMultipleGeometricPatternFile(const MultipleGeometricPattern* multiplePattern, const char* fileName, const char* description);

//============================================================================
//  Calibration functions
//============================================================================
//IMAQ_FUNC int              IMAQ_STDCALL imaqCopyCalibrationInfo2(Image* dest, Image* source, Point offset);
//IMAQ_FUNC int              IMAQ_STDCALL imaqCorrectCalibratedImage(Image* dest, const Image* source, PixelValue fill, InterpolationMethod method, const ROI* roi);
//IMAQ_FUNC CalibrationInfo* IMAQ_STDCALL imaqGetCalibrationInfo2(const Image* image);
//IMAQ_FUNC int              IMAQ_STDCALL imaqLearnCalibrationGrid(Image* image, const ROI* roi, const LearnCalibrationOptions* options, const GridDescriptor* grid, const CoordinateSystem* system, const RangeFloat* range, float* quality);
//IMAQ_FUNC int              IMAQ_STDCALL imaqLearnCalibrationPoints(Image* image, const CalibrationPoints* points, const ROI* roi, const LearnCalibrationOptions* options, const GridDescriptor* grid, const CoordinateSystem* system, float* quality);
//IMAQ_FUNC int              IMAQ_STDCALL imaqSetCoordinateSystem(Image* image, const CoordinateSystem* system);
//IMAQ_FUNC int              IMAQ_STDCALL imaqSetSimpleCalibration(Image* image, ScalingMethod method, int learnTable, const GridDescriptor* grid, const CoordinateSystem* system);
//IMAQ_FUNC TransformReport* IMAQ_STDCALL imaqTransformPixelToRealWorld(const Image* image, const PointFloat* pixelCoordinates, int numCoordinates);
//IMAQ_FUNC TransformReport* IMAQ_STDCALL imaqTransformRealWorldToPixel(const Image* image, const PointFloat* realWorldCoordinates, int numCoordinates);

//============================================================================
//  Overlay functions
//============================================================================
//IMAQ_FUNC int IMAQ_STDCALL imaqClearOverlay(Image* image, const char* group);
//IMAQ_FUNC int IMAQ_STDCALL imaqCopyOverlay(Image* dest, const Image* source, const char* group);
//IMAQ_FUNC int IMAQ_STDCALL imaqGetOverlayProperties(Image* image, const char* group, TransformBehaviors* transformBehaviors);
//IMAQ_FUNC int IMAQ_STDCALL imaqMergeOverlay(Image* dest, const Image* source, const RGBValue* palette, unsigned int numColors, const char* group);
//IMAQ_FUNC int IMAQ_STDCALL imaqOverlayArc(Image* image, const ArcInfo* arc, const RGBValue* color, DrawMode drawMode, const char* group);
//IMAQ_FUNC int IMAQ_STDCALL imaqOverlayBitmap(Image* image, Point destLoc, const RGBValue* bitmap, unsigned int numCols, unsigned int numRows, const char* group);
//IMAQ_FUNC int IMAQ_STDCALL imaqOverlayClosedContour(Image* image, const Point* points, int numPoints, const RGBValue* color, DrawMode drawMode, const char* group);
//IMAQ_FUNC int IMAQ_STDCALL imaqOverlayLine(Image* image, Point start, Point end, const RGBValue* color, const char* group);
//IMAQ_FUNC int IMAQ_STDCALL imaqOverlayMetafile(Image* image, const void* metafile, Rect rect, const char* group);
//IMAQ_FUNC int IMAQ_STDCALL imaqOverlayOpenContour(Image* image, const Point* points, int numPoints, const RGBValue* color, const char* group);
//IMAQ_FUNC int IMAQ_STDCALL imaqOverlayOval(Image* image, Rect boundingBox, const RGBValue* color, DrawMode drawMode, char* group);
//IMAQ_FUNC int IMAQ_STDCALL imaqOverlayPoints(Image* image, const Point* points, int numPoints, const RGBValue* colors, int numColors, PointSymbol symbol, const UserPointSymbol* userSymbol, const char* group);
//IMAQ_FUNC int IMAQ_STDCALL imaqOverlayRect(Image* image, Rect rect, const RGBValue* color, DrawMode drawMode, const char* group);
//IMAQ_FUNC int IMAQ_STDCALL imaqOverlayROI(Image* image, const ROI* roi, PointSymbol symbol, const UserPointSymbol* userSymbol, const char* group);
//IMAQ_FUNC int IMAQ_STDCALL imaqOverlayText(Image* image, Point origin, const char* text, const RGBValue* color, const OverlayTextOptions* options, const char* group);
//IMAQ_FUNC int IMAQ_STDCALL imaqSetOverlayProperties(Image* image, const char* group, TransformBehaviors* transformBehaviors);

//============================================================================
//  Color Matching functions
//============================================================================
//IMAQ_FUNC ColorInformation* IMAQ_STDCALL imaqLearnColor(const Image* image, const ROI* roi, ColorSensitivity sensitivity, int saturation);
//IMAQ_FUNC int*              IMAQ_STDCALL imaqMatchColor(const Image* image, const ColorInformation* info, const ROI* roi, int* numScores);

//============================================================================
//  Meter functions
//============================================================================
//IMAQ_FUNC MeterArc* IMAQ_STDCALL imaqGetMeterArc(int lightNeedle, MeterArcMode mode, const ROI* roi, PointFloat base, PointFloat start, PointFloat end);
//IMAQ_FUNC int       IMAQ_STDCALL imaqReadMeter(const Image* image, const MeterArc* arcInfo, double* percentage, PointFloat* endOfNeedle);

//============================================================================
//  Barcode I/O functions
//============================================================================
//IMAQ_FUNC int               IMAQ_STDCALL imaqGradeDataMatrixBarcodeAIM(const Image* image, AIMGradeReport* report);
//IMAQ_FUNC BarcodeInfo*      IMAQ_STDCALL imaqReadBarcode(const Image* image, BarcodeType type, const ROI* roi, int validate);
//IMAQ_FUNC DataMatrixReport* IMAQ_STDCALL imaqReadDataMatrixBarcode2(Image* image, const ROI* roi, DataMatrixGradingMode prepareForGrading, const DataMatrixDescriptionOptions* descriptionOptions, const DataMatrixSizeOptions* sizeOptions, const DataMatrixSearchOptions* searchOptions);
//IMAQ_FUNC Barcode2DInfo*    IMAQ_STDCALL imaqReadPDF417Barcode(const Image* image, const ROI* roi, Barcode2DSearchMode searchMode, unsigned int* numBarcodes);
//IMAQ_FUNC QRCodeReport*     IMAQ_STDCALL imaqReadQRCode(Image* image, const ROI* roi, QRGradingMode reserved, const QRCodeDescriptionOptions* descriptionOptions, const QRCodeSizeOptions* sizeOptions, const QRCodeSearchOptions* searchOptions);

//============================================================================
//  Shape Matching functions
//============================================================================
//IMAQ_FUNC ShapeReport* IMAQ_STDCALL imaqMatchShape(Image* dest, Image* source, const Image* templateImage, int scaleInvariant, int connectivity8, double tolerance, int* numMatches);

//============================================================================
//  Contours functions
//============================================================================
//IMAQ_FUNC ContourID     IMAQ_STDCALL imaqAddAnnulusContour(ROI* roi, Annulus annulus);
//IMAQ_FUNC ContourID     IMAQ_STDCALL imaqAddClosedContour(ROI* roi, const Point* points, int numPoints);
//IMAQ_FUNC ContourID     IMAQ_STDCALL imaqAddLineContour(ROI* roi, Point start, Point end);
//IMAQ_FUNC ContourID     IMAQ_STDCALL imaqAddOpenContour(ROI* roi, const Point* points, int numPoints);
//IMAQ_FUNC ContourID     IMAQ_STDCALL imaqAddOvalContour(ROI* roi, Rect boundingBox);
//IMAQ_FUNC ContourID     IMAQ_STDCALL imaqAddPointContour(ROI* roi, Point point);
//IMAQ_FUNC ContourID     IMAQ_STDCALL imaqAddRectContour(ROI* roi, Rect rect);
//IMAQ_FUNC ContourID     IMAQ_STDCALL imaqAddRotatedRectContour2(ROI* roi, RotatedRect rect);
//IMAQ_FUNC ContourID     IMAQ_STDCALL imaqCopyContour(ROI* destRoi, const ROI* sourceRoi, ContourID id);
//IMAQ_FUNC ContourID     IMAQ_STDCALL imaqGetContour(const ROI* roi, unsigned int index);
//IMAQ_FUNC int           IMAQ_STDCALL imaqGetContourColor(const ROI* roi, ContourID id, RGBValue* contourColor);
//IMAQ_FUNC int           IMAQ_STDCALL imaqGetContourCount(const ROI* roi);
//IMAQ_FUNC ContourInfo2* IMAQ_STDCALL imaqGetContourInfo2(const ROI* roi, ContourID id);
//IMAQ_FUNC int           IMAQ_STDCALL imaqMoveContour(ROI* roi, ContourID id, int deltaX, int deltaY);
//IMAQ_FUNC int           IMAQ_STDCALL imaqRemoveContour(ROI* roi, ContourID id);
//IMAQ_FUNC int           IMAQ_STDCALL imaqSetContourColor(ROI* roi, ContourID id, const RGBValue* color);

//============================================================================
//  Regions of Interest functions
//============================================================================
//IMAQ_FUNC int  IMAQ_STDCALL imaqConstructROI2(const Image* image, ROI* roi, Tool initialTool, const ToolWindowOptions* tools, const ConstructROIOptions2* options, int* okay);
//IMAQ_FUNC ROI* IMAQ_STDCALL imaqCreateROI();
//IMAQ_FUNC int  IMAQ_STDCALL imaqGetROIBoundingBox(const ROI* roi, Rect* boundingBox);
//IMAQ_FUNC int  IMAQ_STDCALL imaqGetROIColor(const ROI* roi, RGBValue* roiColor);
//IMAQ_FUNC ROI* IMAQ_STDCALL imaqGetWindowROI(int windowNumber);
//IMAQ_FUNC int  IMAQ_STDCALL imaqSetROIColor(ROI* roi, const RGBValue* color);
//IMAQ_FUNC int  IMAQ_STDCALL imaqSetWindowROI(int windowNumber, const ROI* roi);

//============================================================================
//  Image Analysis functions
//============================================================================
//IMAQ_FUNC int              IMAQ_STDCALL imaqCentroid(const Image* image, PointFloat* centroid, const Image* mask);
//IMAQ_FUNC Curve*           IMAQ_STDCALL imaqExtractCurves(const Image* image, const ROI* roi, const CurveOptions* curveOptions, unsigned int* numCurves);
//IMAQ_FUNC HistogramReport* IMAQ_STDCALL imaqHistogram(const Image* image, int numClasses, float min, float max, const Image* mask);
//IMAQ_FUNC LineProfile*     IMAQ_STDCALL imaqLineProfile(const Image* image, Point start, Point end);
//IMAQ_FUNC QuantifyReport*  IMAQ_STDCALL imaqQuantify(const Image* image, const Image* mask);

//============================================================================
//  Error Management functions
//============================================================================
//IMAQ_FUNC int         IMAQ_STDCALL imaqClearError();
//IMAQ_FUNC char*       IMAQ_STDCALL imaqGetErrorText(int errorCode);
//IMAQ_FUNC const char* IMAQ_STDCALL imaqGetLastErrorFunc();
//IMAQ_FUNC int         IMAQ_STDCALL imaqSetError(int errorCode, const char* function);

//============================================================================
//  Threshold functions
//============================================================================
//IMAQ_FUNC ThresholdData* IMAQ_STDCALL imaqAutoThreshold2(Image* dest, const Image* source, int numClasses, ThresholdMethod method, const Image* mask);
//IMAQ_FUNC int            IMAQ_STDCALL imaqLocalThreshold(Image* dest, const Image* source, unsigned int windowWidth, unsigned int windowHeight, LocalThresholdMethod method, double deviationWeight, ObjectType type, float replaceValue);
//IMAQ_FUNC int            IMAQ_STDCALL imaqMagicWand(Image* dest, const Image* source, Point coord, float tolerance, int connectivity8, float replaceValue);
//IMAQ_FUNC int            IMAQ_STDCALL imaqMultithreshold(Image* dest, const Image* source, const ThresholdData* ranges, int numRanges);
//IMAQ_FUNC int            IMAQ_STDCALL imaqThreshold(Image* dest, const Image* source, float rangeMin, float rangeMax, int useNewValue, float newValue);

//============================================================================
//  Memory Management functions
//============================================================================
//============================================================================
//  File I/O functions
//============================================================================
//IMAQ_FUNC int         IMAQ_STDCALL imaqCloseAVI(AVISession session);
//IMAQ_FUNC AVISession  IMAQ_STDCALL imaqCreateAVI(const char* fileName, const char* compressionFilter, int quality, unsigned int framesPerSecond, unsigned int maxDataSize);
//IMAQ_FUNC int         IMAQ_STDCALL imaqGetAVIInfo(AVISession session, AVIInfo* info);
//IMAQ_FUNC int         IMAQ_STDCALL imaqGetFileInfo(const char* fileName, CalibrationUnit* calibrationUnit, float* calibrationX, float* calibrationY, int* width, int* height, ImageType* imageType);
//IMAQ_FUNC FilterName* IMAQ_STDCALL imaqGetFilterNames(int* numFilters);
//IMAQ_FUNC char**      IMAQ_STDCALL imaqLoadImagePopup(const char* defaultDirectory, const char* defaultFileSpec, const char* fileTypeList, const char* title, int allowMultiplePaths, ButtonLabel buttonLabel, int restrictDirectory, int restrictExtension, int allowCancel, int allowMakeDirectory, int* cancelled, int* numPaths);
//IMAQ_FUNC AVISession  IMAQ_STDCALL imaqOpenAVI(const char* fileName);
//IMAQ_FUNC int         IMAQ_STDCALL imaqReadAVIFrame(Image* image, AVISession session, unsigned int frameNum, void* data, unsigned int* dataSize);
//IMAQ_FUNC int         IMAQ_STDCALL imaqReadVisionFile(Image* image, const char* fileName, RGBValue* colorTable, int* numColors);
//IMAQ_FUNC int         IMAQ_STDCALL imaqWriteAVIFrame(Image* image, AVISession session, const void* data, unsigned int dataLength);
//IMAQ_FUNC int         IMAQ_STDCALL imaqWriteBMPFile(const Image* image, const char* fileName, int compress, const RGBValue* colorTable);
//IMAQ_FUNC int         IMAQ_STDCALL imaqWriteJPEGFile(const Image* image, const char* fileName, unsigned int quality, void* colorTable);
//IMAQ_FUNC int         IMAQ_STDCALL imaqWriteJPEG2000File(const Image* image, const char* fileName, int lossless, float compressionRatio, const JPEG2000FileAdvancedOptions* advancedOptions, const RGBValue* colorTable);
//IMAQ_FUNC int         IMAQ_STDCALL imaqWritePNGFile2(const Image* image, const char* fileName, unsigned int compressionSpeed, const RGBValue* colorTable, int useBitDepth);
//IMAQ_FUNC int         IMAQ_STDCALL imaqWriteTIFFFile(const Image* image, const char* fileName, const TIFFFileOptions* options, const RGBValue* colorTable);
//IMAQ_FUNC int         IMAQ_STDCALL imaqWriteVisionFile(const Image* image, const char* fileName, const RGBValue* colorTable);


//============================================================================
//  Frequency Domain Analysis functions
//============================================================================
//IMAQ_FUNC int IMAQ_STDCALL imaqAttenuate(Image* dest, const Image* source, AttenuateMode highlow);
//IMAQ_FUNC int IMAQ_STDCALL imaqConjugate(Image* dest, const Image* source);
//IMAQ_FUNC int IMAQ_STDCALL imaqFFT(Image* dest, const Image* source);
//IMAQ_FUNC int IMAQ_STDCALL imaqFlipFrequencies(Image* dest, const Image* source);
//IMAQ_FUNC int IMAQ_STDCALL imaqInverseFFT(Image* dest, const Image* source);
//IMAQ_FUNC int IMAQ_STDCALL imaqTruncate(Image* dest, const Image* source, TruncateMode highlow, float ratioToKeep);

//============================================================================
//  Pixel Manipulation functions
//============================================================================
//IMAQ_FUNC int    IMAQ_STDCALL imaqArrayToComplexPlane(Image* dest, const Image* source, const float* newPixels, ComplexPlane plane);
//IMAQ_FUNC float* IMAQ_STDCALL imaqComplexPlaneToArray(const Image* image, ComplexPlane plane, Rect rect, int* columns, int* rows);
//IMAQ_FUNC int    IMAQ_STDCALL imaqExtractComplexPlane(Image* dest, const Image* source, ComplexPlane plane);
//IMAQ_FUNC int    IMAQ_STDCALL imaqFillImage(Image* image, PixelValue value, const Image* mask);
//IMAQ_FUNC void*  IMAQ_STDCALL imaqGetLine(const Image* image, Point start, Point end, int* numPoints);
//IMAQ_FUNC int    IMAQ_STDCALL imaqGetPixel(const Image* image, Point pixel, PixelValue* value);
//IMAQ_FUNC int    IMAQ_STDCALL imaqReplaceComplexPlane(Image* dest, const Image* source, const Image* newValues, ComplexPlane plane);
//IMAQ_FUNC int    IMAQ_STDCALL imaqSetLine(Image* image, const void* array, int arraySize, Point start, Point end);
//IMAQ_FUNC int    IMAQ_STDCALL imaqSetPixel(Image* image, Point coord, PixelValue value);

//============================================================================
//  LCD functions
//============================================================================
//IMAQ_FUNC int        IMAQ_STDCALL imaqFindLCDSegments(ROI* roi, const Image* image, const LCDOptions* options);
//IMAQ_FUNC LCDReport* IMAQ_STDCALL imaqReadLCD(const Image* image, const ROI* roi, const LCDOptions* options);

//============================================================================
//  Regions of Interest Manipulation functions
//============================================================================
//IMAQ_FUNC ROI*        IMAQ_STDCALL imaqMaskToROI(const Image* mask, int* withinLimit);
//IMAQ_FUNC ROIProfile* IMAQ_STDCALL imaqROIProfile(const Image* image, const ROI* roi);
//IMAQ_FUNC int         IMAQ_STDCALL imaqROIToMask(Image* mask, const ROI* roi, int fillValue, const Image* imageModel, int* inSpace);
//IMAQ_FUNC int         IMAQ_STDCALL imaqTransformROI2(ROI* roi, const CoordinateSystem* baseSystem, const CoordinateSystem* newSystem);

//============================================================================
//  OCR functions
//============================================================================
//IMAQ_FUNC CharSet*         IMAQ_STDCALL imaqCreateCharSet();
//IMAQ_FUNC int              IMAQ_STDCALL imaqDeleteChar(CharSet* set, int index);
//IMAQ_FUNC int              IMAQ_STDCALL imaqGetCharCount(const CharSet* set);
//IMAQ_FUNC CharInfo2*       IMAQ_STDCALL imaqGetCharInfo2(const CharSet* set, int index);
//IMAQ_FUNC int              IMAQ_STDCALL imaqReadOCRFile(const char* fileName, CharSet* set, String255 setDescription, ReadTextOptions* readOptions, OCRProcessingOptions* processingOptions, OCRSpacingOptions* spacingOptions);
//IMAQ_FUNC ReadTextReport3* IMAQ_STDCALL imaqReadText3(const Image* image, const CharSet* set, const ROI* roi, const ReadTextOptions* readOptions, const OCRProcessingOptions* processingOptions, const OCRSpacingOptions* spacingOptions);
//IMAQ_FUNC int              IMAQ_STDCALL imaqRenameChar(CharSet* set, int index, const char* newCharValue);
//IMAQ_FUNC int              IMAQ_STDCALL imaqSetReferenceChar(const CharSet* set, int index, int isReferenceChar);
//IMAQ_FUNC int              IMAQ_STDCALL imaqTrainChars(const Image* image, CharSet* set, int index, const char* charValue, const ROI* roi, const OCRProcessingOptions* processingOptions, const OCRSpacingOptions* spacingOptions);
//IMAQ_FUNC int*             IMAQ_STDCALL imaqVerifyPatterns(const Image* image, const CharSet* set, const String255* expectedPatterns, int patternCount, const ROI* roi, int* numScores);
//IMAQ_FUNC int*             IMAQ_STDCALL imaqVerifyText(const Image* image, const CharSet* set, const char* expectedString, const ROI* roi, int* numScores);
//IMAQ_FUNC int              IMAQ_STDCALL imaqWriteOCRFile(const char* fileName, const CharSet* set, const char* setDescription, const ReadTextOptions* readOptions, const OCRProcessingOptions* processingOptions, const OCRSpacingOptions* spacingOptions);

//============================================================================
//  Classification functions
//============================================================================
//IMAQ_FUNC int                            IMAQ_STDCALL imaqAddClassifierSample(Image* image, ClassifierSession* session, const ROI* roi, const char* sampleClass, double* featureVector, unsigned int vectorSize);
//IMAQ_FUNC ClassifierReport*              IMAQ_STDCALL imaqClassify(Image* image, const ClassifierSession* session, const ROI* roi, double* featureVector, unsigned int vectorSize);
//IMAQ_FUNC ClassifierSession*             IMAQ_STDCALL imaqCreateClassifier(ClassifierType type);
//IMAQ_FUNC int                            IMAQ_STDCALL imaqDeleteClassifierSample(ClassifierSession* session, int index);
//IMAQ_FUNC ClassifierAccuracyReport*      IMAQ_STDCALL imaqGetClassifierAccuracy(const ClassifierSession* session);
//IMAQ_FUNC ClassifierSampleInfo*          IMAQ_STDCALL imaqGetClassifierSampleInfo(const ClassifierSession* session, int index, int* numSamples);
//IMAQ_FUNC int                            IMAQ_STDCALL imaqGetNearestNeighborOptions(const ClassifierSession* session, NearestNeighborOptions* options);
//IMAQ_FUNC int                            IMAQ_STDCALL imaqGetParticleClassifierOptions(const ClassifierSession* session, ParticleClassifierPreprocessingOptions* preprocessingOptions, ParticleClassifierOptions* options);
//IMAQ_FUNC ClassifierSession*             IMAQ_STDCALL imaqReadClassifierFile(ClassifierSession* session, const char* fileName, ReadClassifierFileMode mode, ClassifierType* type, ClassifierEngineType* engine, String255 description);
//IMAQ_FUNC int                            IMAQ_STDCALL imaqRelabelClassifierSample(ClassifierSession* session, int index, const char* newClass);
//IMAQ_FUNC int                            IMAQ_STDCALL imaqSetParticleClassifierOptions(ClassifierSession* session, const ParticleClassifierPreprocessingOptions* preprocessingOptions, const ParticleClassifierOptions* options);
//IMAQ_FUNC NearestNeighborTrainingReport* IMAQ_STDCALL imaqTrainNearestNeighborClassifier(ClassifierSession* session, const NearestNeighborOptions* options);
//IMAQ_FUNC int                            IMAQ_STDCALL imaqWriteClassifierFile(const ClassifierSession* session, const char* fileName, WriteClassifierFileMode mode, const String255 description);

//============================================================================
//  Inspection functions
//============================================================================
//IMAQ_FUNC int IMAQ_STDCALL imaqCompareGoldenTemplate(const Image* image, Image* goldenTemplate, Image* brightDefects, Image* darkDefects, const InspectionAlignment* alignment, const InspectionOptions* options);
//IMAQ_FUNC int IMAQ_STDCALL imaqLearnGoldenTemplate(Image* goldenTemplate, PointFloat originOffset, const Image* mask);

//============================================================================
//  Morphology functions
//============================================================================
//IMAQ_FUNC int IMAQ_STDCALL imaqGrayMorphology(Image* dest, Image* source, MorphologyMethod method, const StructuringElement* structuringElement);



