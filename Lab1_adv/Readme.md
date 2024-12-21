# Chthonic Being Generator

## Project Description
This project is a Java application designed to generate and analyze data about mythical and supernatural beings, referred to as "chthonic beings." The application performs the following tasks:

1. Generates an infinite stream of chthonic beings with random attributes.
2. Filters and collects a list of 500 beings, skipping a configurable number of initial entries.
3. Groups the beings by their type and filters them based on the number of years since their first mention in literature.
4. Calculates statistical metrics for the beings' attack power, including minimum, maximum, average, and standard deviation.
5. Identifies outliers in the attack power values using the interquartile range (IQR) and classifies them.

## Features
- Infinite generator of chthonic beings with random attributes such as name, type, first mention date, and attack power.
- Stream-based processing of data for filtering, grouping, and analysis.
- Statistical analysis of attack power using custom collectors.
- Identification and categorization of outliers in attack power.

## Prerequisites
- Java 11 or later
- Maven or other build tools (optional, for managing dependencies and building the project)

## How to Run
1. Clone this repository to your local machine:
   ```bash
   git clone <repository-url>
   ```
2. Navigate to the project directory:
   ```bash
   cd chthonic-being-generator
   ```
3. Compile the project:
   ```bash
   javac -d out src/*.java
   ```
4. Run the application:
   ```bash
   java -cp out ChthonicBeingGenerator
   ```

## Code Structure
The project is divided into the following classes:

### 1. `ChthonicBeing`
Represents a single chthonic being with the following attributes:
- `name`: Name of the being.
- `type`: Type of the being (e.g., Demon, Spirit, Monster).
- `firstMentionDate`: Date when the being was first mentioned in literature.
- `attackPower`: A numeric value representing the being's strength.

### 2. `ChthonicBeingGenerator`
Contains the main method to generate, process, and analyze the beings. It orchestrates the use of other classes for filtering, grouping, and statistical analysis.

### 3. `StatisticsCollector`
Custom collector to calculate:
- Minimum attack power
- Maximum attack power
- Average attack power
- Standard deviation of attack power

### 4. `AttackOutlierAnalyzer`
Analyzes the attack power values to identify outliers based on the interquartile range (IQR). Categorizes beings into "data" (within bounds) and "outliers" (outside bounds).

## Example Output
```
Min Attack: 1, Max Attack: 99, Avg Attack: 50.67, Std Dev: 14.32
{data=412, outliers=88}
```

## Development Standards
- **Code Style**: The code follows Google Java Code Style guidelines.
- **Documentation**: Each class and method is documented with Javadoc.

## Author
- **Name**: [Borodai Vladyslav]

## License
This project is open-source and available under the MIT License.

