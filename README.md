# Udemy Real-Time Data Pipeline & Analytics

A Big Data project focusing on building a complete data pipeline: from real-time ingestion via **Apache Kafka** to large-scale processing and visualization using **Apache Spark** on the **Databricks** platform.

## 📌 Project Overview
The system captures live-streamed course data from a simulated Udemy API, processes the messages through a Kafka cluster, and performs deep analytics to identify market trends, pricing strategies, and user engagement metrics.

## 🚀 System Architecture
1. **Source**: Data is streamed via a Dockerized API service (`bigdata-g1`).
2. **Ingestion (Producer)**: A Scala-based Kafka Producer fetches data from the REST endpoint and pushes it to a Kafka topic.
3. **Stream Processing (Consumer/Spark)**: The data is consumed, transformed, and stored in persistent formats (CSV/Parquet).
4. **Analytics (Databricks)**: Data is imported into a Databricks workspace where Spark SQL and DataFrames are used for complex statistical analysis and visualization.

## 🛠 Tech Stack
- **Language**: Scala
- **Build Tool**: SBT
- **Infrastructure**: Docker & Docker Compose
- **Message Broker**: Apache Kafka & Zookeeper
- **Big Data Engine**: Apache Spark (Databricks)
- **Library Dependencies**: `kafka-clients`, `scalaj-http`, `slf4j`

## ⚙️ How to Run

### 1. Start Infrastructure
Launch the Kafka and Zookeeper environment using Docker Compose:
```bash
docker-compose up -d
```

### 2. Start the Source Stream
Load the provided Docker image for the data stream:
```bash
docker load -i bigdata-g1.tar
docker run -d -p 5000:5000 --name bigdata-g1 bigdata-g1:latest
```

### 3. Run the Kafka Producer
Navigate to the project directory and run the Scala application::
```bash
sbt run
```

## 📊 Databricks Analysis & Results
Once the data is ingested, 5 key analyses were performed within the Databricks notebook:
1. Course Category Distribution: Breakdown of courses across disciplines (Web Development, Business, Music, etc.).
2. Pricing Strategy Analysis: Relationship between course prices, difficulty levels, and the number of subscribers.
3. Sentiment & Rating Correlation: Evaluating how ratings affect subscriber growth over time.
4. Content Popularity (Subscribers vs. Reviews): Identifying high-engagement niches vs. high-purchase niches.
5. Growth Forecasting: Using regression models to predict course performance based on content length and price.

## 📂 Project Structure
- VP - projekat/: Main Scala source code and SBT configuration.
- docker-compose.yml: Configuration for Zookeeper and Kafka.
- Databricks Scala - VP.ipynb: Notebook containing the final Spark analysis and visualizations.
- src/main/scala/com/UdemyProducer.scala: Core logic for API data fetching and Kafka production.
